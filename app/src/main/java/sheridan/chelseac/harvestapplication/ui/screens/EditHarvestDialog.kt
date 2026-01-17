package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

@Composable
fun EditHarvestDialog(
    harvest: HarvestEntity,
    onDismiss: () -> Unit,
    onUpdate: (HarvestEntity) -> Unit
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
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        showError = false
                    },
                    label = { Text("Crop Name") },
                    isError = showError && name.isBlank()
                )

                OutlinedTextField(
                    value = quantity,
                    onValueChange = {
                        quantity = it
                        showError = false
                    },
                    label = { Text("Quantity") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    isError = showError && !isQuantityValid
                )

                OutlinedTextField(
                    value = date,
                    onValueChange = {
                        date = it
                        showError = false
                    },
                    label = { Text("Date (YYYY-MM-DD)") },
                    isError = showError && date.isBlank()
                )

                if (showError) {
                    Text(
                        "Please enter valid values",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                if (name.isBlank() || !isQuantityValid || date.isBlank()) {
                    showError = true
                } else {
                    onUpdate(
                        harvest.copy(
                            name = name.trim(),
                            quantity = quantity.toInt(),
                            date = date.trim()
                        )
                    )
                }
            }) {
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
