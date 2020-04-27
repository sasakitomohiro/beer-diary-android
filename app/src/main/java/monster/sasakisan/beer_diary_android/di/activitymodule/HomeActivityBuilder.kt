package monster.sasakisan.beer_diary_android.di.activitymodule

import dagger.Module
import dagger.android.ContributesAndroidInjector
import monster.sasakisan.beer_diary_android.ui.main.HomeActivity

@Module
interface HomeActivityBuilder {
  @ContributesAndroidInjector(modules = [
    HomeActivityModule::class,
    HomeViewModelModule::class
  ])
  fun contributeHomeActivity(): HomeActivity
}
