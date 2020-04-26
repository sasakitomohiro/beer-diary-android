package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import monster.sasakisan.beer_diary_android.ui.main.MainActivity
import monster.sasakisan.beer_diary_android.ui.main.MainFragment

@Module
interface MainActivityModule {
  @Binds
  fun bindsAppCompatActivity(activity: MainActivity): AppCompatActivity

  @ContributesAndroidInjector
  fun contributeMainFragment(): MainFragment
}
