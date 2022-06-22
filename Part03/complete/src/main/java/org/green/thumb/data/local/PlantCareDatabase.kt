package org.green.thumb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.green.thumb.data.Plant
import org.green.thumb.data.PlantCare

@Database(entities = [Plant::class, PlantCare::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PlantCareDatabase : RoomDatabase() {
    abstract fun plantCareDao(): PlantCareDao
}