package monster.sasakisan.beer_diary_android.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.AndroidSupportInjection
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.FragmentHomeBinding
import monster.sasakisan.beer_diary_android.util.bindView

class HomeFragment : Fragment(R.layout.fragment_home) {
  private lateinit var binding: FragmentHomeBinding

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

    with(binding.recyclerView) {
      adapter = beerAdapter
      layoutManager = GridLayoutManager(context, beerAdapter.spanCount)
    }

    val items = (1..100).map {
      BeerItem("beer$it", "")
    }

    beerAdapter.update(items)
  }
}