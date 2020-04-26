package monster.sasakisan.beer_diary_android.di.activitymodule

import dagger.Module
import dagger.android.ContributesAndroidInjector
import monster.sasakisan.beer_diary_android.ui.main.MainActivity

@Module
interface MainActivityBuilder {
  @ContributesAndroidInjector(modules = [
    MainActivityModule::class,
    MainViewModelModule::class
  ])
  fun contributeMainActivity(): MainActivity
}
