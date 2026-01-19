package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("No gardens yet")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Tap + to add your first garden")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(gardens) { garden ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = garden.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = garden.type,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
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
            onSave = { name, type ->
                viewModel.addGarden(name, type)
                showDialog = false
            }
        )
    }
}
