package monster.sasakisan.beer_diary_android.ui.main

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import monster.sasakisan.beer_diary_android.R

class MainActivity : DaggerAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}
