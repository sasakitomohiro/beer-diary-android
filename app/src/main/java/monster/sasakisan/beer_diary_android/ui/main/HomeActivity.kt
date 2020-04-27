package monster.sasakisan.beer_diary_android.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.ActivityHomeBinding
import monster.sasakisan.beer_diary_android.util.bindView
import javax.inject.Inject

class HomeActivity : AppCompatActivity(R.layout.activity_home), HasAndroidInjector {
  private val binding by lazy { bindView<ActivityHomeBinding>() }

  @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

//    findNavController(R.)
  }

  override fun androidInjector(): AndroidInjector<Any> {
    return androidInjector
  }
}
