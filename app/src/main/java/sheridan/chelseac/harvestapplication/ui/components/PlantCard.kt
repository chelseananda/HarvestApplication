package sheridan.chelseac.harvestapplication.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.model.Plant

@Composable
fun PlantCard(
    plant: Plant,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            // Image placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Image")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = plant.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = plant.sunlight,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
