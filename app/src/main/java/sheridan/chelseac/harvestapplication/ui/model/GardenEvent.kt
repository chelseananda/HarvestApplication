package sheridan.chelseac.harvestapplication.ui.model

import androidx.appcompat.widget.DialogTitle

//calendar events
data class GardenEvent(
    val id: Int,
    val title: String,
    val date: String,
    val gardenName: String
)
