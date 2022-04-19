package sheridan.chelseac.harvestapplication.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import sheridan.chelseac.harvestapplication.GardenFragment
import sheridan.chelseac.harvestapplication.PlantListFragment

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1

class HarvestPagerAdapter(fragment: Fragment) :FragmentStateAdapter(fragment) {
    private val tabFragmentsCreators: Map<Int, () -> Any> = mapOf(
        MY_GARDEN_PAGE_INDEX to { GardenFragment() },
        PLANT_LIST_PAGE_INDEX to { PlantListFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return (tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()) as Fragment
    }
}