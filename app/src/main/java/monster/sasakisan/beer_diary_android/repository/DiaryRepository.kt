package monster.sasakisan.beer_diary_android.repository

import monster.sasakisan.beer_diary_android.db.model.DiaryDao
import monster.sasakisan.beer_diary_android.model.Diary
import javax.inject.Inject

class DiaryRepository @Inject constructor(private val diaryDao: DiaryDao) {
  suspend fun add(diary: Diary) {
    diaryDao.add(diary.convertToDao())
  }
}
