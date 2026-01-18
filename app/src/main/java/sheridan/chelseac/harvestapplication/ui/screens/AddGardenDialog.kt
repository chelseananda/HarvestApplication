package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun AddGardenDialog(
    onDismiss: () -> Unit,
    onSave: (String) -> Unit
) {
    var gardenName by remember { mutableStateOf(TextFieldValue("")) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("New Garden")
        },
        text = {
            OutlinedTextField(
                value = gardenName,
                onValueChange = { gardenName = it },
                label = { Text("Garden name") }
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onSave(gardenName.text)
                    onDismiss()
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
