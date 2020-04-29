package monster.sasakisan.beer_diary_android.di.activitymodule

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dagger.Module
import dagger.Provides
import monster.sasakisan.beer_diary_android.ui.beerdiaryeditor.BeerDiaryEditorActivity
import monster.sasakisan.beer_diary_android.ui.beerdiaryeditor.BeerDiaryEditorViewModel

@Module
class BeerDiaryEditorViewModelModule {
  @Provides
  fun provideBeerDiaryEditorViewModel(
    activity: BeerDiaryEditorActivity,
    factory: BeerDiaryEditorViewModel.Factory
  ): BeerDiaryEditorViewModel = ViewModelProvider(activity, factory).get()
}
