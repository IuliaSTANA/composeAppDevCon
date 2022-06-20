package org.green.thumb

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.green.thumb.addedit.AddEditPlantScreen
import org.green.thumb.addedit.AddEditPlantViewModel
import org.green.thumb.overview.PlantOverviewScreen
import org.green.thumb.overview.PlantOverviewViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PlantOverviewRoute
    ) {
        composable(PlantOverviewRoute) {
            PlantOverviewScreen(PlantOverviewViewModel()) { navController.navigate(AddPlantRoute) }
        }
        composable(AddPlantRoute) {
            AddEditPlantScreen(
                plantId = null,
                onPlantUpdate = { navController.navigate(PlantOverviewRoute) },
                viewModel = AddEditPlantViewModel(),
            )
        }
    }
}

const val PlantOverviewRoute = "overviewRoute"
const val AddPlantRoute = "addPlantRoute"
