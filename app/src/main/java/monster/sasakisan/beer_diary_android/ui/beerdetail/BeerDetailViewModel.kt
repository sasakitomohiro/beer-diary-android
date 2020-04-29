package monster.sasakisan.beer_diary_android.ui.beerdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monster.sasakisan.beer_diary_android.model.Diary
import monster.sasakisan.beer_diary_android.repository.DiaryRepository
import javax.inject.Inject

class BeerDetailViewModel(
  private val diaryRepository: DiaryRepository
) : ViewModel() {
  class Factory @Inject constructor(
    private val diaryRepository: DiaryRepository
  ) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return BeerDetailViewModel(diaryRepository) as T
    }
  }

  private val isSuccessMutableLiveData =  MutableLiveData<Boolean>()
  val isSuccess: LiveData<Boolean> = isSuccessMutableLiveData

  private val diaryMutableLiveData =  MutableLiveData<Diary>()
  val diary: LiveData<Diary> = diaryMutableLiveData

  fun add(diary: Diary) {
    viewModelScope.launch {
      runCatching { diaryRepository.add(diary) }
        .onSuccess { isSuccessMutableLiveData.postValue(true) }
        .onFailure { isSuccessMutableLiveData.postValue(false) }
    }
  }

  fun get(id: Long) {
    viewModelScope.launch {
      runCatching { diaryRepository.get(id) }
        .onSuccess { diaryMutableLiveData.postValue(it) }
        .onFailure { isSuccessMutableLiveData.postValue(false) }
    }
  }
}
