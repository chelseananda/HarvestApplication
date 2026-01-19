package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import sheridan.chelseac.harvestapplication.ui.model.Guide

class GuideViewModel : ViewModel() {

    private val guides = listOf(
        Guide(
            id = 1,
            title = "Beginner Gardening",
            subtitle = "Start your first garden",
            description = "Learn the basics of gardening, soil preparation, watering, and sunlight."
        ),
        Guide(
            id = 2,
            title = "Seasonal Planting",
            subtitle = "What to grow & when",
            description = "Discover which plants grow best in each season and climate."
        ),
        Guide(
            id = 3,
            title = "Indoor Plants",
            subtitle = "Grow plants inside",
            description = "Tips for growing herbs and vegetables indoors with limited sunlight."
        )
    )

    fun getGuides(): List<Guide> = guides
}
