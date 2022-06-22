package org.green.thumb.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.green.thumb.data.local.PlantsDataSource
import org.green.thumb.data.local.PlantCareDatabase
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalPlantsDataSource

    @Singleton
    @LocalPlantsDataSource
    @Provides
    fun provideTasksLocalDataSource(
        database: PlantCareDatabase,
        ioDispatcher: CoroutineDispatcher,
    ): PlantsDataSource {
        return PlantsDataSource(
            database.plantCareDao(), ioDispatcher
        )
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): PlantCareDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PlantCareDatabase::class.java,
            "Plants.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}