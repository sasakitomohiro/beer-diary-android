package monster.sasakisan.beer_diary_android.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import monster.sasakisan.beer_diary_android.db.BeerDiaryDatabase
import monster.sasakisan.beer_diary_android.db.model.DiaryDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
internal object RoomModule {
  @Singleton
  @Provides
  fun provideRoomDatabase(application: Application): BeerDiaryDatabase {
    return Room.databaseBuilder(application, BeerDiaryDatabase::class.java, "beer-diary-db")
      .build()
  }

  @Provides
  fun provideDiaryDao(beerDiaryDatabase: BeerDiaryDatabase): DiaryDao {
    return beerDiaryDatabase.diaryDao()
  }
}
