package monster.sasakisan.beer_diary_android.ui.common

import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment

class CustomNavHostFragment : NavHostFragment() {
  override fun createFragmentNavigator(): Navigator<out FragmentNavigator.Destination> {
    return CustomNavigator(requireContext(), childFragmentManager, id)
  }
}
