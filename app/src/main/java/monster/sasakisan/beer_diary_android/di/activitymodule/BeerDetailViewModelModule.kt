package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dagger.Module
import dagger.Provides
import monster.sasakisan.beer_diary_android.ui.beerdetail.BeerDetailActivity
import monster.sasakisan.beer_diary_android.ui.beerdetail.BeerDetailViewModel

@Module
class BeerDetailViewModelModule {
  @Provides
  fun provideBeerDetailViewModel(
    activity: BeerDetailActivity,
    factory: BeerDetailViewModel.Factory
  ): BeerDetailViewModel = ViewModelProvider(activity, factory).get()
}
