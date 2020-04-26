package monster.sasakisan.beer_diary_android.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import monster.sasakisan.beer_diary_android.App
import monster.sasakisan.beer_diary_android.di.activitymodule.MainActivityBuilder
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    MainActivityBuilder::class
  ]
)
interface AppComponent : AndroidInjector<App> {
  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: App): AppComponent
  }

  override fun inject(application: App)
}
