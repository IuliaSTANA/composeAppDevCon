package org.green.thumb.data

/**
 * Plant detail information model
 * @param name The name of the plant (scientific, common or nicknames)
 * @param location Where the plant is located
 * @param wateringFrequency Level of watering required for the specific plant, range from 0-2
 * @param lightRequirement Average temperature required for the plant to thrive
 * @param shouldDoMisting Whether misting is required instead of watering
 */
data class Plant(
    val name: String = "",
    val description: String = "",
    val location: String = "",
    val wateringFrequency: Int = 0,
    val lightRequirement: Int = 0,
    val temperature: Int = 0,
    val shouldDoMisting: Boolean = false,
    val careLog: List<PlantCare> = emptyList(),
)
