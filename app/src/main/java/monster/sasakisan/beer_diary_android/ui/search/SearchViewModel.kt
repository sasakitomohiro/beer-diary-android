package monster.sasakisan.beer_diary_android.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import monster.sasakisan.beer_diary_android.repository.DiaryRepository

class SearchViewModel @ViewModelInject constructor(
  private val diaryRepository: DiaryRepository
) : ViewModel() {
}
