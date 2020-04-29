package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import monster.sasakisan.beer_diary_android.ui.beerdiaryeditor.BeerDiaryEditorActivity

@Module
interface BeerDiaryEditorActivityModule {
  @Binds
  fun bindsAppCompatActivity(activity: BeerDiaryEditorActivity): AppCompatActivity
}
