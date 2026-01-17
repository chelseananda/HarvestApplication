package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.components.HarvestItem
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel

@Composable
fun HarvestScreen(
    viewModel: HarvestViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Text("+")
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(uiState.harvests) { harvest ->
                HarvestItem(
                    harvest = harvest,
                    onDelete = { viewModel.deleteHarvest(harvest) }
                )
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
