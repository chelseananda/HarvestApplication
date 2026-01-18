package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity
import sheridan.chelseac.harvestapplication.ui.components.EmptyState
import sheridan.chelseac.harvestapplication.ui.components.HarvestItem
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel

@Composable
fun HarvestListScreen(
    viewModel: HarvestViewModel
) {
    // Collect data from Room (Flow → State)
    val harvests by viewModel.harvests.collectAsState(initial = emptyList())

    // UI state
    var showAddDialog by remember { mutableStateOf(false) }
    var selectedHarvest by remember { mutableStateOf<HarvestEntity?>(null) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true }
            ) {
                Text("+")
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            // EMPTY STATE
            if (harvests.isEmpty()) {
                EmptyState(
                    message = "No harvests yet.\nTap + to add one."
                )
            }
            // LIST STATE
            else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(harvests) { harvest ->
                        HarvestItem(
                            harvest = harvest,
                            onClick = {
                                selectedHarvest = harvest
                            },
                            onDelete = {
                                viewModel.deleteHarvest(harvest)
                            }
                        )
                    }
                }
            }
        }
    }

    /* ---------------- ADD DIALOG ---------------- */

    if (showAddDialog) {
        AddHarvestDialog(
            onDismiss = { showAddDialog = false },
            onSave = { name, quantity, date ->
                viewModel.addHarvest(name, quantity, date)
                showAddDialog = false
            }
        )
    }

    /* ---------------- EDIT DIALOG ---------------- */

    selectedHarvest?.let { harvest ->
        EditHarvestDialog(
            harvest = harvest,
            onDismiss = { selectedHarvest = null },
            onSave = { id, name, quantity, date ->
                viewModel.updateHarvest(id, name, quantity, date)
                selectedHarvest = null
            }
        )
    }
}
