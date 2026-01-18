package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
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

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // handled elsewhere (Add dialog)
            }) {
                Text("+")
            }
        }
    ) { padding ->

        if (harvests.isEmpty()) {
            EmptyState(
                modifier = Modifier.padding(padding)
            )
        } else {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                harvests.forEach { harvest ->

                    HarvestItem(
                        harvest = harvest,
                        onClick = { /* optional edit */ },
                        onDelete = {
                            viewModel.deleteHarvest(harvest)

                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    message = "Harvest deleted",
                                    actionLabel = "UNDO",
                                    duration = SnackbarDuration.Short
                                )

                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.undoDelete()
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
