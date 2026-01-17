package sheridan.chelseac.harvestapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.R
import sheridan.chelseac.harvestapplication.databinding.FragmentBotanistGardenBinding
import sheridan.chelseac.harvestapplication.ui.adapters.GardenAdapter
import sheridan.chelseac.harvestapplication.viewmodels.GardenViewModel

/**
 * UI Controller for the user's personal garden collection.
 * Graduate Level Concept: Lifecycle-aware data collection and modern RecyclerView implementation.
 */
@AndroidEntryPoint
class GardenFragment : Fragment() {

    private val viewModel: GardenViewModel by viewModels()
    private var _binding: FragmentBotanistGardenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBotanistGardenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the adapter with a callback for the "Water" action
        val adapter = GardenAdapter { item ->
            viewModel.waterPlant(item.userPlant)
        }
        binding.gardenList.adapter = adapter

        binding.addPlantFab.setOnClickListener {
            findNavController().navigate(R.id.action_garden_to_catalog)
        }

        // Setup UI state collection using modern Kotlin Flow
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.gardenItems.collect { items ->
                    binding.emptyGardenText.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
                    adapter.submitList(items)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
