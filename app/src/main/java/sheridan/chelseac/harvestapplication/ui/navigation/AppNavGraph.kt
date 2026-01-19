package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sheridan.chelseac.harvestapplication.ui.screens.*
import sheridan.chelseac.harvestapplication.ui.viewmodel.GardenViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel

@Composable
fun AppNavGraph(
    viewModel: HarvestViewModel
) {
    val navController = rememberNavController()

    //CREATED GardenViewModel HERE
    val gardenViewModel: GardenViewModel = viewModel()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = NavRoutes.GARDEN
        ) {

            composable(NavRoutes.GARDEN) {
                GardenScreen(
                    padding = padding,
                    viewModel = gardenViewModel
                )
            }

            composable(NavRoutes.PLANTS) {
                PlantScreen(
                    padding = padding,
                    navController = navController
                )
            }

            composable(NavRoutes.CALENDAR) {
                CalendarScreen(padding = padding)
            }

            composable(NavRoutes.GUIDE) {
                GuideScreen(padding = padding)
            }

            composable(NavRoutes.PLANT_DETAIL) {
                PlantDetailScreen(padding = padding)
            }
        }
    }
}
