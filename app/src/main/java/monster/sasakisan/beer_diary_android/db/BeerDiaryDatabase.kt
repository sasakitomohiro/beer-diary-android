package monster.sasakisan.beer_diary_android.db

import androidx.room.Database
import androidx.room.RoomDatabase
import monster.sasakisan.beer_diary_android.db.model.Diary
import monster.sasakisan.beer_diary_android.db.model.DiaryDao

@Database(
  entities = [
    Diary::class
  ],
  version = 1
)
abstract class BeerDiaryDatabase : RoomDatabase() {
  abstract fun diaryDao(): DiaryDao
}
