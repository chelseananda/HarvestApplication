// ui/screens/PlantDetailScreen.kt
package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.viewmodel.PlantViewModel

@Composable
fun PlantDetailScreen(
    padding: PaddingValues,
    plantId: Int,
    viewModel: PlantViewModel = PlantViewModel()
) {
    val plant = viewModel.getPlantById(plantId) ?: return

    Column(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(plant.name, style = MaterialTheme.typography.headlineMedium)
        Text("Sunlight: ${plant.sunlight}")
        Text("Water: ${plant.water}")
        Text("Harvest: ${plant.daysToHarvest}")
        Text(plant.description)
    }
}
