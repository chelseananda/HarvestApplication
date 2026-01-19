package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.model.Plant

@Composable
fun PlantDetailScreen(
    plant: Plant,
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp)
            .fillMaxSize()
    ) {

        Text(
            text = plant.name,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("☀️ Sunlight: ${plant.sunlight}")
        Text("💧 Water: ${plant.water}")
        Text("🌱 Harvest Time: ${plant.daysToHarvest}")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = plant.description)
    }
}
