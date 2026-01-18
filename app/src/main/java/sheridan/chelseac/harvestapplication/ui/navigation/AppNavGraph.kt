package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sheridan.chelseac.harvestapplication.ui.screens.CalendarScreen
import sheridan.chelseac.harvestapplication.ui.screens.GardenScreen
import sheridan.chelseac.harvestapplication.ui.screens.GuideScreen
import sheridan.chelseac.harvestapplication.ui.screens.PlantDetailScreen
import sheridan.chelseac.harvestapplication.ui.screens.PlantScreen
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel

@Composable
fun AppNavGraph(
    viewModel: HarvestViewModel
) {
    // Single NavController for the entire app
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = NavRoutes.GARDEN
        ) {

            //  Garden tab
            composable(NavRoutes.GARDEN) {
                GardenScreen(
                    padding = padding
                )
            }

            //  Plants tab
            composable(NavRoutes.PLANTS) {
                PlantScreen(
                    padding = padding,
                    navController = navController
                )
            }

            //  Calendar tab
            composable(NavRoutes.CALENDAR) {
                CalendarScreen(
                    padding = padding
                )
            }

            //  Guide tab
            composable(NavRoutes.GUIDE) {
                GuideScreen(
                    padding = padding
                )
            }

            //  Plant detail screen (opened from Plants)
            composable(NavRoutes.PLANT_DETAIL) {
                PlantDetailScreen(
                    padding = padding
                )
            }
        }
    }
}
