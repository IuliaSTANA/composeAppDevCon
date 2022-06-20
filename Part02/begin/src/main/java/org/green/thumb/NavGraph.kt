package org.green.thumb

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.green.thumb.addedit.AddEditPlantContent
import org.green.thumb.data.SampleData
import org.green.thumb.overview.PlantOverview

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AddPlantRoute
    ) {
        composable(PlantOverviewRoute) { PlantOverview(SampleData.plantInventory) }
        composable(AddPlantRoute) { AddEditPlantContent() }
    }
}

const val PlantOverviewRoute = "overviewRoute"
const val AddPlantRoute = "addPlantRoute"
