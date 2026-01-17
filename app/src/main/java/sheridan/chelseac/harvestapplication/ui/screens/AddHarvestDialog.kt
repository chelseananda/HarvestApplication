package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

/**
 * Dialog for adding a new harvest item
 */
@Composable
fun AddHarvestDialog(
    onDismiss: () -> Unit,
    onSave: (String, Int, String) -> Unit
) {

    var name by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    var showError by remember { mutableStateOf(false) }

    val isQuantityValid = quantity.toIntOrNull() != null

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Add Harvest")
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        showError = false
                    },
                    label = { Text("Crop Name") },
                    modifier = Modifier.fillMaxWidth(),
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
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && !isQuantityValid
                )

                OutlinedTextField(
                    value = date,
                    onValueChange = {
                        date = it
                        showError = false
                    },
                    label = { Text("Date (YYYY-MM-DD)") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && date.isBlank()
                )

                if (showError) {
                    Text(
                        text = "Please enter valid values in all fields",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (
                        name.isBlank() ||
                        quantity.isBlank() ||
                        !isQuantityValid ||
                        date.isBlank()
                    ) {
                        showError = true
                    } else {
                        onSave(
                            name.trim(),
                            quantity.toInt(),
                            date.trim()
                        )
                    }
                }
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
