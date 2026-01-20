package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.components.CalendarEventCard
import sheridan.chelseac.harvestapplication.ui.dialogs.AddEventDialog
import sheridan.chelseac.harvestapplication.ui.viewmodel.CalendarViewModel

@Composable
fun CalendarScreen(
    padding: PaddingValues,
    viewModel: CalendarViewModel
) {
    val events by viewModel.events.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {

        if (events.isEmpty()) {
            Text(
                text = "No calendar events yet",
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                events.forEach { event ->
                    CalendarEventCard(
                        event = event,
                        onDelete = { viewModel.deleteEvent(event) }
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

    if (showDialog) {
        AddEventDialog(
            onDismiss = { showDialog = false },
            onAdd = { title, date, gardenName ->
                viewModel.addEvent(title, date, gardenName)
            }
        )
    }
}
