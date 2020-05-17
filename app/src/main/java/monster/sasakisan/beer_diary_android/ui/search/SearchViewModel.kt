package monster.sasakisan.beer_diary_android.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import monster.sasakisan.beer_diary_android.repository.DiaryRepository
import javax.inject.Inject

class SearchViewModel(private val diaryRepository: DiaryRepository) : ViewModel() {
  class Factory @Inject constructor(
    private val diaryRepository: DiaryRepository
  ) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return SearchViewModel(diaryRepository) as T
    }
  }
}
