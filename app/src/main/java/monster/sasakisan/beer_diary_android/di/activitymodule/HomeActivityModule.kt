package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import monster.sasakisan.beer_diary_android.ui.home.HomeActivity
import monster.sasakisan.beer_diary_android.ui.home.HomeFragment
import monster.sasakisan.beer_diary_android.ui.settings.SettingsFragment
import monster.sasakisan.beer_diary_android.ui.search.SearchFragment

@Module
interface HomeActivityModule {
  @Binds
  fun bindsAppCompatActivity(activity: HomeActivity): AppCompatActivity

  @ContributesAndroidInjector
  fun contributeHomeFragment(): HomeFragment

  @ContributesAndroidInjector
  fun contributeSearchFragment(): SearchFragment

  @ContributesAndroidInjector
  fun contributeSettingsFragment(): SettingsFragment
}
