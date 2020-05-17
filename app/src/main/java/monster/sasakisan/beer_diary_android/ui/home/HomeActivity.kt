package monster.sasakisan.beer_diary_android.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.ActivityHomeBinding
import monster.sasakisan.beer_diary_android.ui.common.CustomNavHostFragment
import monster.sasakisan.beer_diary_android.util.bindView
import javax.inject.Inject

class HomeActivity : AppCompatActivity(R.layout.activity_home), HasAndroidInjector {
  private val binding: ActivityHomeBinding by lazy { bindView<ActivityHomeBinding>() }

  @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
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

  override fun androidInjector(): AndroidInjector<Any> {
    return androidInjector
  }
}
