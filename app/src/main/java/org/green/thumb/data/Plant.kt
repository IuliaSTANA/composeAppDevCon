package org.green.thumb.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Plant detail information model
 * @param name The name of the plant (scientific, common or nicknames)
 * @param location Where the plant is located
 * @param wateringFrequency Level of watering required for the specific plant, range from 0-2
 * @param lightRequirement Average temperature required for the plant to thrive
 * @param shouldDoMisting Whether misting is required instead of watering
 * @param entryId Id for the plant
 */
@Entity(tableName = "plants")
data class Plant(
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "description") val description: String = "",
    @ColumnInfo(name = "location") val location: String = "",
    @ColumnInfo(name = "wateringRequency") val wateringFrequency: Int = 0,
    @ColumnInfo(name = "lightRequirement") val lightRequirement: Int = 0,
    @ColumnInfo(name = "temperature") val temperature: Int = 0,
    @ColumnInfo(name = "shouldDoMisting") val shouldDoMisting: Boolean = false,
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
)
