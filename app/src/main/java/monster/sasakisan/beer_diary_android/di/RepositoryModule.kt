package monster.sasakisan.beer_diary_android.di

import dagger.Module
import dagger.Provides
import monster.sasakisan.beer_diary_android.db.model.DiaryDao
import monster.sasakisan.beer_diary_android.repository.DiaryRepository
import javax.inject.Singleton

@Module
internal object RepositoryModule {
  @Singleton
  @Provides
  @JvmStatic
  fun provideDiaryRepository(diaryDao: DiaryDao): DiaryRepository = DiaryRepository(diaryDao)
}
