// ui/card/GardenCard.kt
package sheridan.chelseac.harvestapplication.ui.card

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.model.Garden

@Composable
fun GardenCard(
    garden: Garden,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = garden.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Plants: ${garden.plantCount}")
        }
    }
}

