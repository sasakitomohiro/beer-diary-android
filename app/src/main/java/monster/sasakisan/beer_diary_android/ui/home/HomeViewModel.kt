package monster.sasakisan.beer_diary_android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monster.sasakisan.beer_diary_android.model.Diary
import monster.sasakisan.beer_diary_android.repository.DiaryRepository
import javax.inject.Inject

class HomeViewModel(
  private val diaryRepository: DiaryRepository
) : ViewModel() {
  class Factory @Inject constructor(
    private val diaryRepository: DiaryRepository
  ) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return HomeViewModel(diaryRepository) as T
    }
  }

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
