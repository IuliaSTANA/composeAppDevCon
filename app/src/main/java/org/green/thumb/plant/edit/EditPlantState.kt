package org.green.thumb.plant.edit

import org.green.thumb.data.Plant

data class EditPlantState(
    val plant: Plant,
    val isLoading: Boolean,
) {
}