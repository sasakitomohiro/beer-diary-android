package monster.sasakisan.beer_diary_android.db.model

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "diary")
data class Diary(
  @PrimaryKey(autoGenerate = true) val id: Long = 0,
  val title: String,
  val content: String,
  @ColumnInfo(name = "image_url") val imageUrl: String
)

@Dao
interface DiaryDao {
  @Insert
  suspend fun add(diary: Diary)

  @Query("SELECT * FROM diary")
  suspend fun getAll(): List<Diary>

  @Query("select * FROM diary where id == :id LIMIT 1")
  suspend fun get(id: Long): Diary
}
