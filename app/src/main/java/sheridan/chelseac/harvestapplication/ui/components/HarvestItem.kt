package sheridan.chelseac.harvestapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HarvestItem(
    harvest: HarvestEntity,
    onDelete: (HarvestEntity) -> Unit,
    onClick: (HarvestEntity) -> Unit
) {
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            if (it == SwipeToDismissBoxValue.EndToStart) {
                onDelete(harvest)
            }
            true
        }
    )

    SwipeToDismissBox(
        state = dismissState,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red)
                    .padding(end = 16.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color.White
                )
            }
        },
        content = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                onClick = { onClick(harvest) }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(harvest.name, style = MaterialTheme.typography.titleMedium)
                    Text("Quantity: ${harvest.quantity}")
                    Text("Date: ${harvest.date}")
                }
            }
        }
    )
}
