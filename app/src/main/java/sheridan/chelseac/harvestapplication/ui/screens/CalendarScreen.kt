package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.ui.components.CalendarEventCard
import sheridan.chelseac.harvestapplication.ui.dialogs.AddEventDialog
import sheridan.chelseac.harvestapplication.ui.viewmodel.CalendarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    padding: PaddingValues,
    viewModel: CalendarViewModel
) {
    val events by viewModel.events.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            if (events.isEmpty()) {
                Text(
                    text = "No calendar events yet",
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(16.dp)
                ) {
                    events.forEach { event ->

                        val dismissState = rememberSwipeToDismissBoxState(
                            confirmValueChange = { value ->
                                if (value == SwipeToDismissBoxValue.EndToStart ||
                                    value == SwipeToDismissBoxValue.StartToEnd
                                ) {
                                    viewModel.deleteEvent(event)

                                    scope.launch {
                                        val result = snackbarHostState.showSnackbar(
                                            message = "Event deleted",
                                            actionLabel = "UNDO"
                                        )
                                        if (result == SnackbarResult.ActionPerformed) {
                                            viewModel.undoDelete()
                                        }
                                    }
                                    true
                                } else {
                                    false
                                }
                            }
                        )

                        SwipeToDismissBox(
                            state = dismissState,
                            backgroundContent = {},
                            content = {
                                CalendarEventCard(
                                    event = event,
                                    onDelete = { viewModel.deleteEvent(event) }
                                )
                            }
                        )
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
    }

    if (showDialog) {
        AddEventDialog(
            onDismiss = { showDialog = false },
            onAdd = { title, date, gardenName ->
                viewModel.addEvent(title, date, gardenName)
            }
        )
    }
}
