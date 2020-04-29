package monster.sasakisan.beer_diary_android.di.activitymodule

import dagger.Module
import dagger.android.ContributesAndroidInjector
import monster.sasakisan.beer_diary_android.ui.beerdetail.BeerDetailActivity

@Module
interface BeerDetailActivityBuilder {
  @ContributesAndroidInjector(modules = [
    BeerDetailActivityModule::class,
    BeerDetailViewModelModule::class
  ])
  fun contributeBeerDetailActivity(): BeerDetailActivity
}
