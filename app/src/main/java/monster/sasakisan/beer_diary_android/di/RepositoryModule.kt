package monster.sasakisan.beer_diary_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import monster.sasakisan.beer_diary_android.db.model.DiaryDao
import monster.sasakisan.beer_diary_android.repository.DiaryRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object RepositoryModule {
  @Provides
  @ActivityRetainedScoped
  fun provideDiaryRepository(
    diaryDao: DiaryDao
  ): DiaryRepository {
    return DiaryRepository(diaryDao)
  }
}
