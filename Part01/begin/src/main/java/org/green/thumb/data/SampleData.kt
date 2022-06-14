package org.green.thumb.data

import java.time.LocalDate

object SampleData {
    val plantInventory = listOf(
        Plant(
            name = "Amaryllis",
            description = "Amaryllis hippeastrum are bulb flowering type plants that produce a cluster of attractive trumpet like flowers in different color variation.",
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
            description = "The Alumnium plant is an easy going house plant that is generally simple to please.. So long as the Pilea cadierei plant gets the water and sunlight it wants it will continue to be a stunning addition to your indoor garden for years to come.",
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
            description = "The blushing bromeliad (Neoregelia carolinae) is part of a large genus of bromeliads and has an interesting way of turning red at it's center when it's about to flower, which is where the common name (blushing) is derived from. ",
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
            description = "The Boston fern is the most popular of all ferns grown indoors and has been found to be one of the easiest to care for and maintain.",
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
            description = "Although an outdoor plant by nature, the Calla Lily will perform wonderfully as an indoor plant. Keeping this rhizome happy indoors is a matter of paying attention to some very basic growing conditions. ",
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
            description = "This low growing plant spreads out to cover the ground it is provided with, offering a visually unique presentation to growers.",
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
            description = "This species that's native to tropical Southeast Asia will let a grower know about it when requesting how much warmth, humidity and water it requires.",
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
            description = "This lush vine does well in most environment's, offering growers a chance to enjoy the plant almost anywhere in the world.",
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
            description = "The Donkey's tail is a succulent plant species that stores water for long periods of time as a fail safe when in its natural habitat water becomes scarce.",
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
            description = "The golden barrel cactus is a globe shaped type cacti suitable for growing in conservatories, on patios or any other type of indoor glass rooms.",
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
            description = "The Jade is grown indoors and borrows itself from the bonsai in the way it grows like a miniature tree, with a trunk and branches. It is also a succulent that will retain water well within the leaves, just like the cactus plant.",
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
            description = "The Jelly Beans Sedum Pachphyllum is a popular succulent plant displaying finger shaped leaves red in color at the tips.",
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
            description = "Watermelon peperomia is the common name used for a popular species from the Peperomia genus named Peperomia argyreia. Named watermelon for its similarity of appearance to the rind (skin) of a watermelon.",
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