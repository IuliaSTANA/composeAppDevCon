package org.green.thumb.overview

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import org.green.thumb.data.Plant
import org.green.thumb.data.SampleData


//TODO: Use this ViewModel to provide data to the overview screen
class PlantOverviewViewModel : ViewModel() {

    private val loadData = MutableLiveData<Unit>()

    val overviewData: LiveData<OverviewData> = loadData.switchMap {
        liveData {
            emit(OverviewData.Loading)
            delay(1000)
            emit(OverviewData.Inventory(SampleData.plantInventory))
//            if (shouldFail()) {
//                emit(OverviewData.Error("Oh noesh...!"))
//            }
        }.distinctUntilChanged()
    }


    init {
        this.loadData.value = Unit
    }

    private fun shouldFail() = (0..10).random().mod(2) == 0

}

sealed interface OverviewData {
    object Loading : OverviewData
    data class Inventory(val plants: List<Plant>, val success: Boolean = true) : OverviewData
    data class Error(val message: String) : OverviewData
}