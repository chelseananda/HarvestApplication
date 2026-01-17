package sheridan.chelseac.harvestapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.databinding.FragmentBotanistCatalogBinding
import sheridan.chelseac.harvestapplication.ui.adapters.CatalogAdapter
import sheridan.chelseac.harvestapplication.viewmodels.CatalogViewModel

/**
 * UI Controller for discovering new botanical entities.
 */
@AndroidEntryPoint
class CatalogFragment : Fragment() {

    private val viewModel: CatalogViewModel by viewModels()
    private var _binding: FragmentBotanistCatalogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBotanistCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CatalogAdapter { plant ->
            // In a graduate level app, we might show a dialog for the nickname,
            // but for now we'll use the common name.
            viewModel.addPlantToGarden(plant, "My ${plant.commonName}")
            Toast.makeText(requireContext(), "Added ${plant.commonName} to your garden!", Toast.LENGTH_SHORT).show()
        }
        binding.catalogList.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.plantCatalog.collect { plants ->
                    adapter.submitList(plants)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
