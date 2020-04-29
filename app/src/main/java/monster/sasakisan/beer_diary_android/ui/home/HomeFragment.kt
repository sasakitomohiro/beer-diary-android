package monster.sasakisan.beer_diary_android.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.AndroidSupportInjection
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.FragmentHomeBinding
import monster.sasakisan.beer_diary_android.ui.beerdiaryeditor.BeerDiaryEditorActivity
import monster.sasakisan.beer_diary_android.util.bindView
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {
  private lateinit var binding: FragmentHomeBinding

  @Inject lateinit var viewModel: HomeViewModel

  private val beerAdapter = GroupAdapter<GroupieViewHolder>().apply {
    spanCount = 2
  }

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = bindView()

    initObserver()

    with(binding.recyclerView) {
      adapter = beerAdapter
      layoutManager = GridLayoutManager(context, beerAdapter.spanCount)
    }

    binding.addButton.setOnClickListener {
      startActivity(BeerDiaryEditorActivity.createIntent(requireContext()))
    }
  }

  override fun onResume() {
    super.onResume()
    viewModel.getAll()
  }

  private fun initObserver() {
    viewModel.isSuccess.observe(viewLifecycleOwner, Observer {

    })
    viewModel.diaryItems.observe(viewLifecycleOwner, Observer {
      beerAdapter.clear()
      val items = it.map {
        BeerItem(it)
      }

      beerAdapter.update(items)
    })
  }
}
