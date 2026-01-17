package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
    // Collect harvest list from ViewModel
    val harvests by viewModel.harvests.collectAsState()

    // UI state
    var showAddDialog by remember { mutableStateOf(false) }
    var selectedHarvest by remember { mutableStateOf<HarvestEntity?>(null) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Harvest"
                )
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            // EMPTY STATE
            if (harvests.isEmpty()) {
                EmptyState()
            }
            // LIST STATE
            else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = harvests,
                        key = { it.id }
                    ) { harvest ->
                        HarvestItem(
                            harvest = harvest,
                            onDelete = { viewModel.deleteHarvest(it) },
                            onClick = { selectedHarvest = it }
                        )
                    }
                }
            }
        }

        // ADD HARVEST DIALOG
        if (showAddDialog) {
            AddHarvestDialog(
                onDismiss = { showAddDialog = false },
                onSave = { name, quantity, date ->
                    viewModel.addHarvest(name, quantity, date)
                    showAddDialog = false
                }
            )
        }

        // EDIT HARVEST DIALOG
        selectedHarvest?.let { harvest ->
            EditHarvestDialog(
                harvest = harvest,
                onDismiss = { selectedHarvest = null },
                onUpdate = {
                    viewModel.updateHarvest(it)
                    selectedHarvest = null
                }
            )
        }
    }
}
