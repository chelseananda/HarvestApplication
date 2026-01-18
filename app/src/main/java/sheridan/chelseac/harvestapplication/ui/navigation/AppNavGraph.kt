package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import sheridan.chelseac.harvestapplication.ui.screens.*

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        padding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Garden.route
        ) {
            composable(BottomNavItem.Garden.route) {
                GardenScreen(padding)
            }
            composable(BottomNavItem.Plants.route) {
                PlantScreen(padding)
            }
            composable(BottomNavItem.Calendar.route) {
                CalenderScreen(padding)
            }
            composable(BottomNavItem.Guide.route) {
                GuideScreen(padding)
            }
        }
    }
}
