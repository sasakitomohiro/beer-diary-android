package monster.sasakisan.beer_diary_android.ui.settings

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.AndroidSupportInjection
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.FragmentSettingsBinding
import monster.sasakisan.beer_diary_android.util.bindView

class SettingsFragment : Fragment(R.layout.fragment_settings) {
  private lateinit var binding: FragmentSettingsBinding

  private val settingsAdapter = GroupAdapter<GroupieViewHolder>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = bindView()
    requireActivity().actionBar?.setDisplayShowHomeEnabled(false)
    requireActivity().actionBar?.setDisplayHomeAsUpEnabled(false)
    setHasOptionsMenu(true)

    with(binding.recyclerView) {
      adapter = settingsAdapter
      layoutManager = LinearLayoutManager(context).apply {
        addItemDecoration(DividerItemDecoration(context, orientation))
      }
    }

    val items = arrayListOf(
      SettingItem("hoge") {

      }
    )

    settingsAdapter.update(items)
  }

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }
}
