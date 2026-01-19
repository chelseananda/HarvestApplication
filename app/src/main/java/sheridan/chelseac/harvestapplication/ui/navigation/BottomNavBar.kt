package sheridan.chelseac.harvestapplication.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {

    val items = listOf(
        BottomNavItem.Garden,
        BottomNavItem.Plants,
        BottomNavItem.Calendar,
        BottomNavItem.Guide
    )

    NavigationBar (
        containerColor = Color(0xFF1E1E1E)
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(BottomNavItem.Garden.route) {
                            saveState = true
                        }
                            launchSingleTop = true
                            restoreState = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.title)
                       },
                label = {
                    Text(item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF9ACD32),
                    selectedTextColor = Color(0xFF9ACD32),
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
