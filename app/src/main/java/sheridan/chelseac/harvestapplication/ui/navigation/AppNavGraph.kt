package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sheridan.chelseac.harvestapplication.ui.screens.*
import sheridan.chelseac.harvestapplication.ui.viewmodel.CalendarViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.CalendarViewModelFactory
import sheridan.chelseac.harvestapplication.ui.viewmodel.GardenViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.GardenViewModelFactory
import sheridan.chelseac.harvestapplication.ui.viewmodel.GuideViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModelFactory
import sheridan.chelseac.harvestapplication.ui.viewmodel.PlantViewModel

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    //Lifecycle-aware ViewModels
    val plantViewModel: PlantViewModel = viewModel()
    val gardenViewModel: GardenViewModel =
        viewModel(factory = GardenViewModelFactory(LocalContext.current))
    val harvestViewModel: HarvestViewModel =
        viewModel(factory = HarvestViewModelFactory(LocalContext.current))
    val calendarViewModel: CalendarViewModel =
        viewModel(factory = CalendarViewModelFactory(LocalContext.current))
    val guideViewModel: GuideViewModel = viewModel()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = NavRoutes.GARDEN
        ) {

            composable(route = NavRoutes.GARDEN) {
                GardenScreen(
                    padding = padding,
                    navController = navController,
                    gardenViewModel = gardenViewModel,
                    calendarViewModel = calendarViewModel
                )
            }

            composable(NavRoutes.PLANTS) {
                PlantScreen(
                    padding = padding,
                    navController = navController,
                    viewModel = plantViewModel
                )
            }

            composable("${NavRoutes.PLANT_DETAIL}/{plantId}") { backStackEntry ->
                val plantId =
                    backStackEntry.arguments?.getString("plantId")?.toInt() ?: 0

                PlantDetailScreen(
                    padding = padding,
                    plantId = plantId,
                    viewModel = plantViewModel
                )
            }

            composable(NavRoutes.CALENDAR) {
                CalendarScreen(
                    padding = padding,
                    viewModel = calendarViewModel
                )
            }

            composable(NavRoutes.GUIDE) {
                GuideScreen(
                    padding = padding,
                    viewModel = guideViewModel
                )
            }
        }
    }
}
