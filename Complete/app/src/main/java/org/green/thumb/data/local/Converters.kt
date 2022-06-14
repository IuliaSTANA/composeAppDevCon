package org.green.thumb.data.local

import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromEpochDay(value: Long?): LocalDate =
        value?.let {
            LocalDate.ofEpochDay(it)
        } ?: LocalDate.MIN

    @TypeConverter
    fun toEpochDay(date: LocalDate?): Long =
        date?.let {
            it.toEpochDay()
        } ?: 0
}

