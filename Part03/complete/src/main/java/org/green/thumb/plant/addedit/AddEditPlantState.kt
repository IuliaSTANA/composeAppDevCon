package org.green.thumb.plant.addedit

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner

@Composable
fun rememberAddEditPlantState(
    plantId: String?,
    viewModel: AddEditPlantViewModel,
    onPlantSaved: () -> Unit,
    defaultChoice: String,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    context: Context = LocalContext.current,
): AddEditPlantState {
    val currentOnPlantSavedState by rememberUpdatedState(onPlantSaved)
    // If any of the parameters passed to `remember` change, a new instance of AddEditTaskState
    // will be created, and the old one will be destroyed.
    return remember(plantId, viewModel, lifecycleOwner, context) {
        AddEditPlantState(
            viewModel = viewModel,
            onPlantSaved = currentOnPlantSavedState,
            defaultChoice = defaultChoice,
            lifecycleOwner = lifecycleOwner
        )
    }
}

/**
 * Responsible for holding state and containing UI-related logic related to [AddEditTaskScreen].
 */
@Stable
class AddEditPlantState(
    private val viewModel: AddEditPlantViewModel,
    defaultChoice: String,
    onPlantSaved: () -> Unit,
    lifecycleOwner: LifecycleOwner,
) {
    var isNameInvalid by mutableStateOf(false)
    var currentWateringChoice by mutableStateOf(defaultChoice)

    init {
        // Listen for plantUpdated events
        viewModel.plantSavedEvent.observe(lifecycleOwner) { saved ->
            if (saved) onPlantSaved()
        }

    }

    fun onSaveClick() {
        validateName()
        if (isNameInvalid) {
            return
        } else {
            viewModel.savePlant()
        }
    }

    fun onNameChange(newName: String) {
        viewModel.setPlantName(newName)
    }

    fun validateName() {
        isNameInvalid = viewModel.isNameInvalid()
    }

    fun onLocationChange(location: String) {
        viewModel.setPlantLocation(location)
    }

    fun onWateringFrequencySelect(wateringFrequency: Int, label: String) {
        viewModel.setPlantWateringFrequency(wateringFrequency)
        currentWateringChoice = label
    }
}