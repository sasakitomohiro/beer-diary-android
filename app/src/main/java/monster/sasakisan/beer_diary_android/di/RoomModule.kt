package monster.sasakisan.beer_diary_android.di

import androidx.room.Room
import dagger.Module
import dagger.Provides
import monster.sasakisan.beer_diary_android.App
import monster.sasakisan.beer_diary_android.db.BeerDiaryDatabase
import monster.sasakisan.beer_diary_android.db.model.DiaryDao
import javax.inject.Singleton

@Module
internal object RoomModule {
  @Singleton
  @Provides
  @JvmStatic
  fun provideRoomDatabase(application: App): BeerDiaryDatabase {
    return Room.databaseBuilder(application, BeerDiaryDatabase::class.java, "beer-diary-db")
      .build()
  }

  @Provides
  fun provideDiaryDao(beerDiaryDatabase: BeerDiaryDatabase): DiaryDao {
    return beerDiaryDatabase.diaryDao()
  }
}
