package sheridan.chelseac.harvestapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.local.UserGardenWithDetails
import sheridan.chelseac.harvestapplication.data.models.UserPlant
import sheridan.chelseac.harvestapplication.data.repository.PlantRepository
import javax.inject.Inject

/**
 * ViewModel for the User's Personal Garden.
 * Graduate Level Concept: UI State Management using StateFlow.
 * We convert the cold Flow from the repository into a hot StateFlow 
 * that survives configuration changes.
 */
@HiltViewModel
class GardenViewModel @Inject constructor(
    private val repository: PlantRepository
) : ViewModel() {

    /**
     * Exposes the user's garden records.
     * stateIn is used to share the flow and keep it active while the UI is visible.
     */
    val gardenItems: StateFlow<List<UserGardenWithDetails>> = repository.getMyGarden()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun waterPlant(userPlant: UserPlant) {
        viewModelScope.launch {
            repository.waterPlant(userPlant)
        }
    }

    fun removePlant(userPlant: UserPlant) {
        viewModelScope.launch {
            repository.removePlantFromGarden(userPlant)
        }
    }
}
