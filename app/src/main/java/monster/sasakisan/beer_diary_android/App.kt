package monster.sasakisan.beer_diary_android

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import monster.sasakisan.beer_diary_android.di.DaggerAppComponent

class App : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent
      .factory()
      .create(this)
  }
}
