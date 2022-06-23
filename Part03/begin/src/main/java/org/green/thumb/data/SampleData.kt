package org.green.thumb.data

import java.time.LocalDate

object SampleData {
    val plantInventory = mutableListOf<Plant>(
        "Amaryllis".let { name ->
            Plant(
                name = name,
                location = "Living Room",
                wateringFrequency = 2,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Re-potting",
                        date = LocalDate.of(2022, 1, 16)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 1, 30)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 2, 15)
                    ),
                )
            )
        },
        "Alumnium Plant".let { name ->
            Plant(
                name = name,
                location = "Living Room",
                wateringFrequency = 2,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Re-potting",
                        date = LocalDate.of(2022, 1, 16)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 1, 30)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 2, 15)
                    ),
                )
            )
        },
        "Blushing Bromeliad".let { name ->
            Plant(
                name = name,
                location = "Living room",
                wateringFrequency = 1,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 2, 18)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 2, 27)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 3)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Boston Fern".let { name ->
            Plant(
                name = name,
                location = "Living room",
                wateringFrequency = 1,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 2, 18)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 2, 27)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 3)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Calla Lily".let { name ->
            Plant(
                name = name,
                location = "Hallway",
                wateringFrequency = 1,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 12)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 27)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Re-potting",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Coral Bead Plant".let { name ->
            Plant(
                name = name,
                location = "Hallway",
                wateringFrequency = 1,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 12)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 27)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Re-potting",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Amazon Elephant's Ear".let { name ->
            Plant(
                name = name,
                location = "Hallway",
                wateringFrequency = 1,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 12)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 27)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Re-potting",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Golden Pothos".let { name ->
            Plant(
                name = name,
                location = "Hallway",
                wateringFrequency = 1,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 12)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 27)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Re-potting",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Donkey's tail".let { name ->
            Plant(
                name = name,
                location = "Balcony",
                wateringFrequency = 3,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 1)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 15)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Golden Barrel Cactus".let { name ->
            Plant(
                name = name,
                location = "Guest bedroom",
                wateringFrequency = 3,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 1)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 15)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Jade Plant".let { name ->
            Plant(
                name = name,
                location = "Guest bedroom",
                wateringFrequency = 3,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 1)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 15)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Jelly Beans".let { name ->
            Plant(
                name = name,
                location = "Guest bedroom",
                wateringFrequency = 3,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 1)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 15)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        },
        "Watermelon Peperomia".let { name ->
            Plant(
                name = name,
                location = "Guest bedroom",
                wateringFrequency = 3,
                careLog = listOf(
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 1)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Watering",
                        date = LocalDate.of(2022, 3, 15)
                    ),
                    PlantCare(
                        plant = name,
                        description = "Fertilizer",
                        date = LocalDate.of(2022, 3, 10)
                    ),
                )
            )
        }
    )
}
