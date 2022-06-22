package org.green.thumb.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
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
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "location") var location: String = "",
    @ColumnInfo(name = "wateringRequency") var wateringFrequency: Int = 0,
    @ColumnInfo(name = "lightRequirement") var lightRequirement: Int = 0,
    @ColumnInfo(name = "temperature") var temperature: Int = 0,
    @ColumnInfo(name = "shouldDoMisting") var shouldDoMisting: Boolean = false,
    @PrimaryKey var id: String = UUID.randomUUID().toString(),
    @Ignore var careLog: List<PlantCare> = emptyList(),
)
