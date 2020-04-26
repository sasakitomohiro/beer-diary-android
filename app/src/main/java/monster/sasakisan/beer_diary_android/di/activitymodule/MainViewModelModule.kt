package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dagger.Module
import dagger.Provides
import monster.sasakisan.beer_diary_android.ui.main.MainActivity
import monster.sasakisan.beer_diary_android.ui.main.MainViewModel

@Module
class MainViewModelModule {
  @Provides
  fun provideMainViewModel(
    activity: MainActivity,
    factory: MainViewModel.Factory
  ): MainViewModel = ViewModelProvider(activity, factory).get()
}
