package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Garden : BottomNavItem(
        route = "garden",
        title = "Garden",
        icon = Icons.Default.GridView
    )

    object Plants : BottomNavItem(
        route = "plants",
        title = "Plants",
        icon = Icons.Default.Eco
    )

    object Calendar : BottomNavItem(
        route = "calendar",
        title = "Calendar",
        icon = Icons.Default.CalendarToday
    )

    object Guide : BottomNavItem(
        route = "guide",
        title = "Guide",
        icon = Icons.Default.Menu
    )
}
