package org.green.thumb

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.green.thumb.overview.PlantsOverviewScreen
import org.green.thumb.welcome.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Welcome
    ) {
        composable(AddPlant) {
//            val viewModel = hiltViewModel<EditPlantViewModel>(it)
//            EditPlantScreen(viewModel, navController::navigate)
        }
        composable(Welcome) { WelcomeScreen(navController::navigate) }
        composable(Overview) { PlantsOverviewScreen() }
    }
}

const val AddPlant = "addPlant"
const val Welcome = "welcomeRoute"
const val Overview = "overviewRoute"