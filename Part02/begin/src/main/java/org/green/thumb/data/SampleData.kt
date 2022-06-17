package org.green.thumb.data

import java.time.LocalDate

object SampleData {
    val plantInventory = mutableListOf<Plant>(
        Plant(
            name = "Amaryllis",
            location = "Living Room",
            wateringFrequency = 2,
            careLog = listOf(
                PlantCare("Re-potting", LocalDate.of(2022, 1, 16)),
                PlantCare("Watering", LocalDate.of(2022, 1, 30)),
                PlantCare("Watering", LocalDate.of(2022, 2, 15)),
            )
        ),
        Plant(
            name = "Alumnium Plant",
            location = "Living Room",
            wateringFrequency = 2,
            careLog = listOf(
                PlantCare("Re-potting", LocalDate.of(2022, 1, 16)),
                PlantCare("Watering", LocalDate.of(2022, 1, 30)),
                PlantCare("Watering", LocalDate.of(2022, 2, 15)),
            )
        ),
        Plant(
            name = "Blushing Bromeliad",
            location = "Living room",
            wateringFrequency = 1,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 2, 18)),
                PlantCare("Watering", LocalDate.of(2022, 2, 27)),
                PlantCare("Watering", LocalDate.of(2022, 3, 3)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Boston Fern",
            location = "Living room",
            wateringFrequency = 1,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 2, 18)),
                PlantCare("Watering", LocalDate.of(2022, 2, 27)),
                PlantCare("Watering", LocalDate.of(2022, 3, 3)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Calla Lily",
            location = "Hallway",
            wateringFrequency = 1,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 12)),
                PlantCare("Watering", LocalDate.of(2022, 3, 27)),
                PlantCare("Re-potting", LocalDate.of(2022, 3, 10)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Coral Bead Plant",
            location = "Hallway",
            wateringFrequency = 1,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 12)),
                PlantCare("Watering", LocalDate.of(2022, 3, 27)),
                PlantCare("Re-potting", LocalDate.of(2022, 3, 10)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Amazon Elephant's Ear",
            location = "Hallway",
            wateringFrequency = 1,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 12)),
                PlantCare("Watering", LocalDate.of(2022, 3, 27)),
                PlantCare("Re-potting", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Golden Pothos",
            location = "Hallway",
            wateringFrequency = 1,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 12)),
                PlantCare("Watering", LocalDate.of(2022, 3, 27)),
                PlantCare("Re-potting", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Donkey's tail",
            location = "Balcony",
            wateringFrequency = 3,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 1)),
                PlantCare("Watering", LocalDate.of(2022, 3, 15)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Golden Barrel Cactus",
            location = "Guest bedroom",
            wateringFrequency = 3,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 1)),
                PlantCare("Watering", LocalDate.of(2022, 3, 15)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Jade Plant",
            location = "Guest bedroom",
            wateringFrequency = 3,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 1)),
                PlantCare("Watering", LocalDate.of(2022, 3, 15)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Jelly Beans",
            location = "Guest bedroom",
            wateringFrequency = 3,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 1)),
                PlantCare("Watering", LocalDate.of(2022, 3, 15)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
        Plant(
            name = "Watermelon Peperomia",
            location = "Guest bedroom",
            wateringFrequency = 3,
            careLog = listOf(
                PlantCare("Watering", LocalDate.of(2022, 3, 1)),
                PlantCare("Watering", LocalDate.of(2022, 3, 15)),
                PlantCare("Fertilizer", LocalDate.of(2022, 3, 10)),
            )
        ),
    )
}