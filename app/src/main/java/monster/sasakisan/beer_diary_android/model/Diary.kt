package monster.sasakisan.beer_diary_android.model

import monster.sasakisan.beer_diary_android.db.model.Diary as DiaryDbModel

data class Diary(
  val id: Long,
  val title: String,
  val content: String,
  val url: String
) {
  companion object {
    fun convert(diary: DiaryDbModel): Diary {
      return Diary(
        id = diary.id,
        title = diary.title,
        content = diary.content,
        url = diary.imageUrl
      )
    }
  }
}
