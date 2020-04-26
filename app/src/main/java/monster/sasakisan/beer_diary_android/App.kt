package monster.sasakisan.beer_diary_android

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import monster.sasakisan.beer_diary_android.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
  @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> {
    DaggerAppComponent
      .factory()
      .create(this)
      .inject(this)
    return androidInjector
  }
}
