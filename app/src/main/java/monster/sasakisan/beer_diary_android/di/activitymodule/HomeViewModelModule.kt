package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dagger.Module
import dagger.Provides
import monster.sasakisan.beer_diary_android.ui.main.HomeActivity
import monster.sasakisan.beer_diary_android.ui.main.HomeViewModel

@Module
class HomeViewModelModule {
  @Provides
  fun provideHomeViewModel(
    activity: HomeActivity,
    factory: HomeViewModel.Factory
  ): HomeViewModel = ViewModelProvider(activity, factory).get()
}
