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
fun HarvestItem(
    harvest: HarvestEntity,
    onLongPress: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onClick = {},
        onLongClick = onLongPress
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(harvest.name, style = MaterialTheme.typography.titleMedium)
            Text("Quantity: ${harvest.quantity}")
            Text("Date: ${harvest.harvestDate}")
        }
    }
}
