package monster.sasakisan.beer_diary_android.ui.main

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.FragmentMainBinding
import monster.sasakisan.beer_diary_android.util.bindView

class MainFragment : Fragment(R.layout.fragment_main) {
  private lateinit var binding: FragmentMainBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = bindView()
  }

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }
}
