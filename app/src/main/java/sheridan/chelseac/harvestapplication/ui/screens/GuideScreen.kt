package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.card.GuideCard
import sheridan.chelseac.harvestapplication.ui.model.Guide
import sheridan.chelseac.harvestapplication.ui.viewmodel.GuideViewModel

@Composable
fun GuideScreen(
    padding: PaddingValues,
    viewModel: GuideViewModel
) {

    // Static beginner-friendly guides (can be replaced with API later)
    val guides = listOf(
        Guide(
            id = 1,
            title = "Getting Started with Gardening",
            category = "Basics",
            description = "Learn the fundamentals of home gardening, soil preparation, and plant care."
        ),
        Guide(
            id = 2,
            title = "Best Plants for Beginners",
            category = "Plants",
            description = "Discover easy-to-grow plants that thrive in most climates."
        ),
        Guide(
            id = 3,
            title = "Watering Schedule Tips",
            category = "Care",
            description = "How often should you water your plants? Learn smart watering techniques."
        ),
        Guide(
            id = 4,
            title = "Understanding Sunlight & Shade",
            category = "Environment",
            description = "Choose the right plants based on sunlight availability."
        )
    )

    Column(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Gardening Guides",
            style = MaterialTheme.typography.titleLarge
        )

        guides.forEach { guide ->
            GuideCard(guide = guide)
        }
    }
}
