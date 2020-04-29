package monster.sasakisan.beer_diary_android.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import monster.sasakisan.beer_diary_android.App
import monster.sasakisan.beer_diary_android.di.activitymodule.BeerDetailActivityBuilder
import monster.sasakisan.beer_diary_android.di.activitymodule.BeerDiaryEditorActivityBuilder
import monster.sasakisan.beer_diary_android.di.activitymodule.HomeActivityBuilder
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    RoomModule::class,
    RepositoryModule::class,
    HomeActivityBuilder::class,
    BeerDetailActivityBuilder::class,
    BeerDiaryEditorActivityBuilder::class
  ]
)
interface AppComponent : AndroidInjector<App> {
  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: App): AppComponent
  }

  override fun inject(application: App)
}
