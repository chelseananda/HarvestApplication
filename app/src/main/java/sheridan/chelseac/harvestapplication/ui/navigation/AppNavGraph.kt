package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sheridan.chelseac.harvestapplication.ui.screens.*
import sheridan.chelseac.harvestapplication.ui.navigation.BottomNavBar
import sheridan.chelseac.harvestapplication.ui.viewmodel.PlantViewModel

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()
    val plantViewModel: PlantViewModel = viewModel()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = NavRoutes.GARDEN
        ) {

            composable(NavRoutes.PLANTS) {
                PlantScreen(
                    padding = padding,
                    navController = navController,
                    viewModel = plantViewModel
                )
            }

            composable(
                route = "${NavRoutes.PLANT_DETAIL}/{plantId}"
            ) { backStackEntry ->

                val plantId =
                    backStackEntry.arguments?.getString("plantId")?.toIntOrNull()

                val plant = plantId?.let {
                    plantViewModel.getPlantById(it)
                }

                plant?.let {
                    PlantDetailScreen(
                        padding = padding,
                        plant = it
                    )
                }
            }
        }
    }
}
