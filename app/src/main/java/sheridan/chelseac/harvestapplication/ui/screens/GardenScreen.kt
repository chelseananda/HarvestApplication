package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.dialog.AddGardenDialog
import sheridan.chelseac.harvestapplication.ui.viewmodel.GardenViewModel

@Composable
fun GardenScreen(
    padding: PaddingValues,
    viewModel: GardenViewModel
) {
    val gardens by viewModel.gardens.collectAsState()
    var showAddGardenDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {

        if (gardens.isEmpty()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Gardens",
                    style = MaterialTheme.typography.headlineLarge
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "You don’t have any garden.\nWant to add some?",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        // ===== LIST STATE =====
        else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(gardens) { garden ->
                    GardenCard(garden.name, garden.type)
                }
            }
        }

        // ===== ADD BUTTON =====
        Button(
            onClick = { showAddGardenDialog = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Text("+ NEW GARDEN")
        }
    }

    if (showAddGardenDialog) {
        AddGardenDialog(
            onDismiss = { showAddGardenDialog = false },
            onCreate = { name, type ->
                viewModel.addGarden(name, type)
                showAddGardenDialog = false
            }
        )
    }
}
