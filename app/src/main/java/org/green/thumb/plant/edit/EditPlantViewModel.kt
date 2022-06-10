package org.green.thumb.plant.edit

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.green.thumb.data.PlantsRepository
import javax.inject.Inject

@HiltViewModel
class EditPlantViewModel @Inject constructor(
    private val plantsRepository: PlantsRepository,
) : ViewModel() {

}