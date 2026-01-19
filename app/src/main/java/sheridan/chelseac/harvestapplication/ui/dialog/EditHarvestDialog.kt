package sheridan.chelseac.harvestapplication.ui.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

@Composable
fun EditHarvestDialog(
    harvest: HarvestEntity,
    onDismiss: () -> Unit,
    onSave: (Int, String, Int, String) -> Unit
) {

    var name by remember { mutableStateOf(harvest.name) }
    var quantity by remember { mutableStateOf(harvest.quantity.toString()) }
    var date by remember { mutableStateOf(harvest.date) }

    var showError by remember { mutableStateOf(false) }
    val isQuantityValid = quantity.toIntOrNull() != null

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Edit Harvest") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Crop Name") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && name.isBlank()
                )

                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = { Text("Quantity") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && !isQuantityValid
                )

                OutlinedTextField(
                    value = date,
                    onValueChange = { date = it },
                    label = { Text("Date") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && date.isBlank()
                )

                if (showError) {
                    Text(
                        text = "Please enter valid values",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (
                        name.isBlank() ||
                        date.isBlank() ||
                        !isQuantityValid
                    ) {
                        showError = true
                    } else {
                        onSave(
                            harvest.id,
                            name.trim(),
                            quantity.toInt(),
                            date.trim()
                        )
                    }
                }
            ) {
                Text("Update")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
