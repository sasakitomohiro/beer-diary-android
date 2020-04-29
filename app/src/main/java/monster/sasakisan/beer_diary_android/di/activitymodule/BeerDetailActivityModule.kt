package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import monster.sasakisan.beer_diary_android.ui.beerdetail.BeerDetailActivity

@Module
interface BeerDetailActivityModule {
  @Binds
  fun bindsAppCompatActivity(activity: BeerDetailActivity): AppCompatActivity
}
