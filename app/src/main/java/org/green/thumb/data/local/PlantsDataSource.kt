package org.green.thumb.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.green.thumb.data.Plant
import org.green.thumb.data.Result

class PlantsDataSource internal constructor(
    private val plantCareDao: PlantCareDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    fun observePlants(): LiveData<Result<List<Plant>>> =
        plantCareDao.observePlants().map {
            Result.Success(it)
        }

    fun observeTask(plantId: String): LiveData<Result<Plant>> =
        plantCareDao.observePlantById(plantId).map {
            Result.Success(it)
        }

    suspend fun getPlants(): Result<List<Plant>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(plantCareDao.getPlants())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    suspend fun getPlant(plantId: String): Result<Plant> = withContext(ioDispatcher) {
        try {
            val plant = plantCareDao.getPlantById(plantId)
            if (plant != null) {
                return@withContext Result.Success(plant)
            } else {
                return@withContext Result.Error(Exception("Plant not found!"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    suspend fun savePlant(plant: Plant) = withContext(ioDispatcher) {
        plantCareDao.insertPlant(plant)
    }

    suspend fun deleteAllPlants() = withContext(ioDispatcher) {
        plantCareDao.deletePlants()
    }

    suspend fun deletePlant(plantId: String) = withContext<Unit>(ioDispatcher) {
        plantCareDao.deletePlantById(plantId)
    }
}