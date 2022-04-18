package sheridan.chelseac.harvestapplication

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private val adapter = GalleryAdapter()
    private val args: GalleryFragmentArgs by navArgs()
}