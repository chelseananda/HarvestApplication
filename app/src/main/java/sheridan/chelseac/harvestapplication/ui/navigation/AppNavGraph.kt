package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sheridan.chelseac.harvestapplication.ui.screens.HarvestListScreen
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel

@Composable
fun AppNavGraph(
    viewModel: HarvestViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "harvest_list"
    ) {
        composable("harvest_list") {
            HarvestListScreen(viewModel = viewModel)
        }
    }
}
