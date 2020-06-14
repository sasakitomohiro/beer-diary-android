package monster.sasakisan.beer_diary_android.ui.search

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.FragmentSearchBinding
import monster.sasakisan.beer_diary_android.util.bindView

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {
  private lateinit var binding: FragmentSearchBinding

  private val viewModel by viewModels<SearchViewModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = bindView()
    setHasOptionsMenu(true)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> backToHome()
    }
    return super.onOptionsItemSelected(item)
  }

  private fun backToHome() {
    findNavController().navigate(R.id.action_search_to_home)
  }
}
