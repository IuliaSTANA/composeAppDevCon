package org.green.thumb

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.green.thumb.overview.PlantOverviewScreen
import org.green.thumb.overview.PlantOverviewViewModel
import org.green.thumb.plant.addedit.AddEditPlantScreen
import org.green.thumb.plant.addedit.AddEditPlantViewModel
import org.green.thumb.welcome.WelcomeScreen

@Composable
fun NavGraph(windowSize: WindowWidthSizeClass) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Welcome
    ) {
        composable(AddPlant) {
            AddEditPlantScreen(
                plantId = null,
                onPlantUpdate = { navController.navigate(Overview) },
                viewModel = AddEditPlantViewModel(),
            )
        }
        composable(Welcome) {
            WelcomeScreen(navController::navigate, windowSize)
        }
        composable(Overview) {
            PlantOverviewScreen(PlantOverviewViewModel(), windowSize) { navController.navigate(AddPlant) }
        }
    }
}

const val Welcome = "welcomeRoute"
const val Overview = "overviewRoute"
const val AddPlant = "addPlantRoute"
