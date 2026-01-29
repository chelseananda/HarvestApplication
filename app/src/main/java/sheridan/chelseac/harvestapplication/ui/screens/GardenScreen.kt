package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sheridan.chelseac.harvestapplication.ui.card.GardenCard
import sheridan.chelseac.harvestapplication.ui.navigation.NavRoutes
import sheridan.chelseac.harvestapplication.ui.viewmodel.CalendarViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.GardenViewModel

@Composable
fun GardenScreen(
    padding: PaddingValues,
    navController: NavController,
    gardenViewModel: GardenViewModel,
    calendarViewModel: CalendarViewModel
) {
    val gardens by gardenViewModel.gardens.collectAsState()

    Column(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        gardens.forEach { garden ->
            GardenCard(
                garden = garden,
                modifier = Modifier.clickable {
                    calendarViewModel.selectGarden(garden.id)
                    navController.navigate(NavRoutes.CALENDAR)
                }
            )
        }
    }
}
