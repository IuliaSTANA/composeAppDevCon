package org.green.thumb.data

import androidx.room.Embedded
import androidx.room.Relation

data class PlantWithCareLog(
    @Embedded
    val plant: Plant,
    @Relation(
        parentColumn = "id",
        entityColumn = "plant"
    )
    val careLogs: List<PlantCare>,
)