package org.green.thumb.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.green.thumb.data.local.PlantsDataSource

class PlantsRepository(
    private val plantsDataSource: PlantsDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun savePlant(task: Plant) {
        coroutineScope {
            launch { plantsDataSource.savePlant(task) }
        }
    }

}