package monster.sasakisan.beer_diary_android.di.activitymodule

import dagger.Module
import dagger.android.ContributesAndroidInjector
import monster.sasakisan.beer_diary_android.ui.beerdiaryeditor.BeerDiaryEditorActivity

@Module
interface BeerDiaryEditorActivityBuilder {
  @ContributesAndroidInjector(modules = [
    BeerDiaryEditorActivityModule::class,
    BeerDiaryEditorViewModelModule::class
  ])
  fun contributeBeerDetailEditorActivity(): BeerDiaryEditorActivity
}
