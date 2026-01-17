package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(harvests) { harvest ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(harvest.name, style = MaterialTheme.typography.titleMedium)
                        Text("Quantity: ${harvest.quantity}")
                        Text("Date: ${harvest.date}")
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
