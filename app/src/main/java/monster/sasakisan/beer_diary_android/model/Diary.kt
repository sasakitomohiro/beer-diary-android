package monster.sasakisan.beer_diary_android.model

import monster.sasakisan.beer_diary_android.db.model.Diary as DiaryDbModel

data class Diary(
  val id: Long = 0,
  val title: String,
  val content: String,
  val url: String,
  val starCount: Float
) {
  fun convertToDao(): DiaryDbModel {
    return DiaryDbModel(
      id = id,
      title = title,
      content = content,
      imageUrl = url,
      starCount = starCount
    )
  }

  companion object {
    fun convert(diary: DiaryDbModel): Diary {
      return Diary(
        id = diary.id,
        title = diary.title,
        content = diary.content,
        url = diary.imageUrl,
        starCount = diary.starCount
      )
    }
  }
}
