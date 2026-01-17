package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel
import sheridan.chelseac.harvestapplication.ui.components.HarvestItem

/**
 * Main harvest screen
 */
@Composable
fun HarvestScreen(viewModel: HarvestViewModel) {

    val uiState by viewModel.uiState.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Text("+")
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            if (uiState.harvestList.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "No harvest records yet",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Tap + to add your first harvest",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            } else {
                LazyColumn {
                    items(uiState.harvestList) { harvest ->
                        HarvestItem(
                            harvest = harvest,
                            onLongPress = {
                                viewModel.deleteHarvest(harvest)
                            }
                        )
                    }
                }
            }

            if (showDialog) {
                AddHarvestDialog(
                    onDismiss = { showDialog = false },
                    onSave = { name, quantity, date ->
                        viewModel.addHarvest(name, quantity, date)
                        showDialog = false
                    }
                )
            }
        }
    }
}
