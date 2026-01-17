package sheridan.chelseac.harvestapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.chelseac.harvestapplication.data.models.Plant
import sheridan.chelseac.harvestapplication.databinding.ItemBotanistCatalogPlantBinding

/**
 * Adapter for the botanical discovery catalog.
 */
class CatalogAdapter(
    private val onAddClick: (Plant) -> Unit
) : ListAdapter<Plant, CatalogAdapter.ViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBotanistCatalogPlantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = getItem(position)
        holder.bind(plant, onAddClick)
    }

    class ViewHolder(private val binding: ItemBotanistCatalogPlantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(plant: Plant, onAddClick: (Plant) -> Unit) {
            binding.plant = plant
            binding.addButton.setOnClickListener { onAddClick(plant) }
            binding.executePendingBindings()
        }
    }

    private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean = oldItem == newItem
    }
}
