// ui/screens/GardenScreen.kt
package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.card.GardenCard
import sheridan.chelseac.harvestapplication.ui.components.EmptyState
import sheridan.chelseac.harvestapplication.ui.dialog.AddGardenDialog
import sheridan.chelseac.harvestapplication.ui.viewmodel.GardenViewModel

@Composable
fun GardenScreen(
    padding: PaddingValues,
    viewModel: GardenViewModel
) {
    val gardens by viewModel.gardens.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {

        if (gardens.isEmpty()) {
            EmptyState("You don’t have any gardens yet.\nAdd one to get started 🌱")
        } else {
            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(gardens) { garden ->
                    GardenCard(garden)
                }
            }
        }

        FloatingActionButton(
            onClick = { showDialog = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text("+")
        }
    }

    if (showDialog) {
        AddGardenDialog(
            onDismiss = { showDialog = false },
            onAdd = { name, type ->
                viewModel.addGarden(name, type)
            }
        )
    }
}
