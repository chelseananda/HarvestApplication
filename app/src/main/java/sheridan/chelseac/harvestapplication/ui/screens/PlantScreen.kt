// ui/screens/PlantScreen.kt
package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sheridan.chelseac.harvestapplication.ui.card.PlantCard
import sheridan.chelseac.harvestapplication.ui.navigation.NavRoutes
import sheridan.chelseac.harvestapplication.ui.viewmodel.PlantViewModel

@Composable
fun PlantScreen(
    padding: PaddingValues,
    navController: NavController,
    viewModel: PlantViewModel = PlantViewModel()
) {
    LazyColumn(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(viewModel.plants) { plant ->
            PlantCard(
                plant = plant,
                onClick = {
                    navController.navigate("${NavRoutes.PLANT_DETAIL}/${plant.id}")
                }
            )
        }
    }
}
