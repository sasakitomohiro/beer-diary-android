package monster.sasakisan.beer_diary_android.ui.beerdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class BeerDetailViewModel : ViewModel() {
  class Factory @Inject constructor() : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return BeerDetailViewModel() as T
    }
  }
}
