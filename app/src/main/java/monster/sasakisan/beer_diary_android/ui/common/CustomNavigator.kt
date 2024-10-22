package monster.sasakisan.beer_diary_android.ui.common

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

@Navigator.Name("custom_fragment")
class CustomNavigator(
  private val context: Context,
  private val manager: FragmentManager,
  private val containerId: Int
) : FragmentNavigator(context, manager, containerId) {

  @Suppress("DEPRECATION")
  override fun navigate(
    destination: Destination,
    args: Bundle?,
    navOptions: NavOptions?,
    navigatorExtras: Navigator.Extras?
  ): NavDestination? {
    if (manager.isStateSaved) {
      return null
    }

    var className = destination.className
    if (className[0] == '.') {
      className = context.packageName + className
    }

    val tag = destination.id.toString()
    val transaction = manager.beginTransaction()

    val currentFragment = manager.primaryNavigationFragment
    if (currentFragment != null) {
      transaction.hide(currentFragment)
    }

    var fragment = manager.findFragmentByTag(tag)
    if (fragment == null) {
      fragment = instantiateFragment(context, manager, className, args)
      transaction.add(containerId, fragment, tag)
    }
    fragment.arguments = args

    transaction.show(fragment)
    transaction.setPrimaryNavigationFragment(fragment)
    transaction.commit()

    return destination
  }
}
