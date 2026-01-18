package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sheridan.chelseac.harvestapplication.ui.components.PlantCard
import sheridan.chelseac.harvestapplication.ui.navigation.NavRoutes

@Composable
fun PlantScreen(
    padding: PaddingValues,
    navController: NavController
) {

    val plants = listOf(
        Plant("Tomato", "Full Sun", "2× / week", "60–100 days"),
        Plant("Carrot", "Partial Sun", "1× / week", "70 days"),
        Plant("Basil", "Full Sun", "3× / week", "30–45 days"),
        Plant("Mint", "Partial Sun", "2× / week", "40 days")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(padding)
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(plants) { plant ->
            PlantCard(
                plant = plant,
                onClick = {
                    navController.navigate(NavRoutes.PLANT_DETAIL)
                }
            )
        }
    }
}
