package monster.sasakisan.beer_diary_android.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monster.sasakisan.beer_diary_android.model.Diary
import monster.sasakisan.beer_diary_android.repository.DiaryRepository

class HomeViewModel @ViewModelInject constructor(
  private val diaryRepository: DiaryRepository
) : ViewModel() {

  private val diaryItemsMutableLiveData = MutableLiveData<List<Diary>>()
  val diaryItems = diaryItemsMutableLiveData

  private val isSuccessMutableLiveData =  MutableLiveData<Boolean>()
  val isSuccess: LiveData<Boolean> = isSuccessMutableLiveData

  fun getAll() {
    viewModelScope.launch {
      runCatching { diaryRepository.getAll() }
        .onSuccess { diaryItemsMutableLiveData.postValue(it) }
        .onFailure { isSuccessMutableLiveData.postValue(false) }
    }
  }
}
