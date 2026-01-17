package sheridan.chelseac.harvestapplication.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

@Composable
fun HarvestItem(
    harvest: HarvestEntity,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = harvest.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "Qty: ${harvest.quantity}")
                Text(text = harvest.date)
            }
            TextButton(onClick = onDelete) {
                Text("Delete")
            }
        }
    }
}
