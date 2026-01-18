package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PlantCard(plant: Plant){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(plant.name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text("☀ ${plant.sunlight}")
            Text("💧 ${plant.water}")
            Text("📅 ${plant.days}")
        }
    }
}