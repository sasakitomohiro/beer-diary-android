package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dagger.Module
import dagger.Provides
import monster.sasakisan.beer_diary_android.ui.home.HomeActivity
import monster.sasakisan.beer_diary_android.ui.search.SearchViewModel

@Module
class SearchViewModelModule {
  @Provides
  fun provideSearchViewModel(
    activity: HomeActivity,
    factory: SearchViewModel.Factory
  ): SearchViewModel = ViewModelProvider(activity, factory).get()
}
