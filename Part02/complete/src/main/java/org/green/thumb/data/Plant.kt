package org.green.thumb.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Plant detail information model
 * @param name The name of the plant (scientific, common or nicknames)
 * @param location Where the plant is located
 * @param wateringFrequency Level of watering required for the specific plant, range from 0-2
 * @param lightRequirement Average temperature required for the plant to thrive
 * @param shouldDoMisting Whether misting is required instead of watering
 */
@Parcelize
data class Plant(
    val name: String = "",
    val location: String = "",
    val wateringFrequency: Int = 0,
    val careLog: List<PlantCare> = emptyList(),
): Parcelable
