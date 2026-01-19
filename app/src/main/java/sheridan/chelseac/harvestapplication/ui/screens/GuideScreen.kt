package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.card.GuideCard
import sheridan.chelseac.harvestapplication.ui.viewmodel.GuideViewModel

@Composable
fun GuideScreen(
    padding: PaddingValues,
    viewModel: GuideViewModel
) {
    val guides = viewModel.getGuides()

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Gardening Guides",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(guides) { guide ->
                GuideCard(guide)
            }
        }
    }
}
