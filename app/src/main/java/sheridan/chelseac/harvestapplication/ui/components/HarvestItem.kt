package sheridan.chelseac.harvestapplication.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

/**
 * Single harvest item UI
 */
@Composable
fun HarvestItem(harvest: HarvestEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = harvest.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Quantity: ${harvest.quantity}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Date: ${harvest.harvestDate}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
