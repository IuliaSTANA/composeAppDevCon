package org.green.thumb.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import org.green.thumb.data.Plant
import org.green.thumb.data.PlantWithCareLog

/**
 * Data Access Object for the plants table with their respective care logs.
 */
@Dao
interface PlantCareDao {

    /**
     * Observes list of plants.
     *
     * @return all plants.
     */
    @Query("SELECT * FROM plants")
    fun observePlants(): LiveData<List<Plant>>

    /**
     * Observes a single plant.
     *
     * @param id the plant id.
     * @return the plant with id.
     */
    @Query("SELECT * FROM plants WHERE id = :id")
    fun observePlantById(id: String): LiveData<Plant>

    /**
     * Select all plants from the plants table.
     *
     * @return all plants.
     */
    @Query("SELECT * FROM plants")
    suspend fun getPlants(): List<Plant>

    /**
     * Select a plant by id.
     *
     * @param id the plant id.
     * @return the plant with id.
     */
    @Query("SELECT * FROM plants WHERE id = :id")
    suspend fun getPlantById(id: String): Plant?

    @Transaction
    @Query("SELECT * FROM plants WHERE id = :id")
    suspend fun getByPlantId(id: String): PlantWithCareLog

    /**
     * Insert a plant in the database. If the plant already exists, replace it.
     *
     * @param plant the plant to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlant(plant: Plant)

    /**
     * Update a plant.
     *
     * @param plant plant to be updated
     * @return the number of plants updated. This should always be 1.
     */
    @Update
    suspend fun updatePlant(plant: Plant): Int

    /**
     * Delete a plant by id.
     *
     * @return the number of plants deleted. This should always be 1.
     */
    @Query("DELETE FROM plants WHERE id = :id")
    suspend fun deletePlantById(id: String): Int

    /**
     * Delete all plants.
     */
    @Query("DELETE FROM plants")
    suspend fun deletePlants()


    @Transaction
    @Query("SELECT * FROM plants")
    suspend fun getAll(): List<PlantWithCareLog>
}
