package org.green.thumb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import org.green.thumb.data.PlantsRepository
import org.green.thumb.data.local.PlantsDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PlantsRepositoryModule {

    @Singleton
    @Provides
    fun providePlantsRepository(
        @AppModule.LocalPlantsDataSource plantsDataSource: PlantsDataSource,
        ioDispatcher: CoroutineDispatcher,
    ): PlantsRepository {
        return PlantsRepository(
            plantsDataSource = plantsDataSource,
            ioDispatcher = ioDispatcher
        )
    }

}