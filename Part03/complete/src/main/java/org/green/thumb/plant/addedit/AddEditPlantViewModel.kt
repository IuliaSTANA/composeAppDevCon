package org.green.thumb.plant.addedit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.green.thumb.data.Plant
import org.green.thumb.data.SampleData

class AddEditPlantViewModel : ViewModel() {
    val currentPlant: LiveData<Plant> = MutableLiveData<Plant>()
    val plantSavedEvent: LiveData<Boolean> = MutableLiveData(false)

    fun savePlant() {
        val newPlantInfo = currentPlant.value ?: Plant()
        viewModelScope.launch {
            SampleData.plantInventory.add(newPlantInfo)
            delay(1000)
            (plantSavedEvent as MutableLiveData).value = true
        }
    }

    fun setPlantName(newName: String) {
        val newPlantInfo = currentPlant.value ?: Plant()
        updateCurrentPlant(newPlantInfo.copy(name = newName))
    }

    fun setPlantLocation(location: String) {
        val newPlantInfo = currentPlant.value ?: Plant()
        updateCurrentPlant(newPlantInfo.copy(location = location))
    }

    fun setPlantWateringFrequency(wateringFrequency: Int) {
        val newPlantInfo = currentPlant.value ?: Plant()
        updateCurrentPlant(newPlantInfo.copy(wateringFrequency = wateringFrequency))
    }

    fun isNameInvalid(): Boolean {
        val currentPlantInfo = currentPlant.value ?: Plant()
        return currentPlantInfo.name.isNullOrEmpty()
    }

    private fun updateCurrentPlant(newPlantInfo: Plant) {
        (currentPlant as MutableLiveData).value = newPlantInfo
    }

}