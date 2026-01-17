package sheridan.chelseac.harvestapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.chelseac.harvestapplication.data.local.UserGardenWithDetails
import sheridan.chelseac.harvestapplication.databinding.ItemBotanistUserPlantBinding

/**
 * Adapter for the personal garden list.
 * Graduate Level Concept: ListAdapter with DiffUtil.
 * This provides high-performance list updates by only refreshing items that changed.
 */
class GardenAdapter(
    private val onWaterClick: (UserGardenWithDetails) -> Unit
) : ListAdapter<UserGardenWithDetails, GardenAdapter.ViewHolder>(GardenDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBotanistUserPlantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onWaterClick)
    }

    class ViewHolder(private val binding: ItemBotanistUserPlantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserGardenWithDetails, onWaterClick: (UserGardenWithDetails) -> Unit) {
            binding.item = item
            binding.waterButton.setOnClickListener { onWaterClick(item) }
            binding.executePendingBindings()
        }
    }

    private class GardenDiffCallback : DiffUtil.ItemCallback<UserGardenWithDetails>() {
        override fun areItemsTheSame(oldItem: UserGardenWithDetails, newItem: UserGardenWithDetails): Boolean {
            return oldItem.userPlant.gardenRecordId == newItem.userPlant.gardenRecordId
        }

        override fun areContentsTheSame(oldItem: UserGardenWithDetails, newItem: UserGardenWithDetails): Boolean {
            return oldItem == newItem
        }
    }
}
