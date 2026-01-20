// ui/card/GardenCard.kt
package sheridan.chelseac.harvestapplication.ui.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.model.Garden

@Composable
fun GardenCard(garden: Garden) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(garden.name, style = MaterialTheme.typography.titleMedium)
            Text(garden.type, style = MaterialTheme.typography.bodySmall)
        }
    }
}
