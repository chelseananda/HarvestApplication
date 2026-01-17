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
import sheridan.chelseac.harvestapplication.ui.components.EmptyState
import sheridan.chelseac.harvestapplication.ui.components.HarvestItem
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel

@Composable
fun HarvestListScreen(
    viewModel: HarvestViewModel
) {
    val harvests by viewModel.harvests.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Harvest")
            }
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            if (harvests.isEmpty()) {
                EmptyState()
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(
                        items = harvests,
                        key = { it.id }
                    ) { harvest ->
                        HarvestItem(
                            harvest = harvest,
                            onDelete = { viewModel.deleteHarvest(it) }
                        )
                    }
                }
            }
        }

        if (showDialog) {
            AddHarvestDialog(
                onDismiss = { showDialog = false },
                onSave = { name, qty, date ->
                    viewModel.addHarvest(name, qty, date)
                    showDialog = false
                }
            )
        }
    }
}
