package monster.sasakisan.beer_diary_android.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.ActivityHomeBinding
import monster.sasakisan.beer_diary_android.ui.common.CustomNavHostFragment
import monster.sasakisan.beer_diary_android.util.bindView

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(R.layout.activity_home) {
  private val binding: ActivityHomeBinding by lazy { bindView<ActivityHomeBinding>() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setSupportActionBar(binding.toolBar)

    val navHostFragment = supportFragmentManager.findFragmentById(binding.container.id) as CustomNavHostFragment
    binding.nav.setupWithNavController(navHostFragment.navController)
    val configuration = AppBarConfiguration(navHostFragment.navController.graph)
    setupActionBarWithNavController(navHostFragment.navController, configuration)

    binding.toolBar.doOnLayout {
      invalidateOptionsMenu()
    }
  }
}
