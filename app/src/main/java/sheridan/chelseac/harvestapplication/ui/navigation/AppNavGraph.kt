package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sheridan.chelseac.harvestapplication.ui.screens.*
import sheridan.chelseac.harvestapplication.ui.viewmodel.CalendarViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.GardenViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.GuideViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.PlantViewModel

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()
    val plantViewModel = remember { PlantViewModel() }
    val gardenViewModel = remember { GardenViewModel() }
    val calendarViewModel = remember { CalendarViewModel() }
    val guideViewModel = remember { GuideViewModel() }


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

            composable("${NavRoutes.PLANT_DETAIL}/{plantId}") { backStackEntry ->
                val plantId = backStackEntry.arguments?.getString("plantId")?.toInt() ?: 0

                PlantDetailScreen(
                    padding = padding,
                    plantId = plantId
                )
            }


            composable(NavRoutes.GARDEN) {
                GardenScreen(
                    padding = padding,
                    viewModel = gardenViewModel
                )
            }

            composable(NavRoutes.CALENDAR) {
                CalendarScreen(
                    padding = padding,
                    viewModel = calendarViewModel
                )
            }

            composable(NavRoutes.GUIDE){
                GuideScreen(
                    padding = padding,
                    viewModel = guideViewModel
                )
            }
        }
    }
}
