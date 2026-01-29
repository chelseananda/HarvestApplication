package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.ui.dialog.AddEventDialog
import sheridan.chelseac.harvestapplication.ui.model.GardenEvent
import sheridan.chelseac.harvestapplication.ui.viewmodel.CalendarViewModel

@Composable
fun CalendarScreen(
    padding: PaddingValues,
    viewModel: CalendarViewModel
) {
    val events by viewModel.events.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var showAddDialog by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true }
            ) {
                Text("+")
            }
        }
    ) { innerPadding ->

        if (events.isEmpty()) {
            EmptyCalendarState(
                modifier = Modifier
                    .padding(padding)
                    .padding(innerPadding)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = events,
                    key = { it.id }
                ) { event ->
                    CalendarEventItem(
                        event = event,
                        onDelete = {
                            viewModel.deleteEvent(event)

                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    message = "Event deleted",
                                    actionLabel = "Undo",
                                    duration = SnackbarDuration.Short
                                )

                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.undoDelete()
                                }
                            }
                        }
                    )
                }
            }
        }

        if (showAddDialog) {
            AddEventDialog(
                onDismiss = { showAddDialog = false },
                onAddEvent = { title, date ->
                    viewModel.addEvent(title, date)
                }
            )
        }
    }
}

@Composable
private fun CalendarEventItem(
    event: GardenEvent,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = event.date,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            TextButton(onClick = onDelete) {
                Text("Delete")
            }
        }
    }
}

@Composable
private fun EmptyCalendarState(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No events yet.\nAdd one to get started 🌱",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
