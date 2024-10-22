package monster.sasakisan.beer_diary_android.ui.beerdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import coil.api.load
import dagger.hilt.android.AndroidEntryPoint
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.ActivityBeerDetailBinding
import monster.sasakisan.beer_diary_android.ui.beerdiaryeditor.BeerDiaryEditorActivity
import monster.sasakisan.beer_diary_android.util.bindView
import java.io.File

@AndroidEntryPoint
class BeerDetailActivity : AppCompatActivity(R.layout.activity_beer_detail) {
  private val binding: ActivityBeerDetailBinding by lazy { bindView<ActivityBeerDetailBinding>() }

  private val viewModel by viewModels<BeerDetailViewModel>()

  private var diaryId = 0L
  private var url = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    initObserver()

    diaryId = intent.getLongExtra(DIARY_ID, 0)

    binding.edit.setOnClickListener {
      startActivity(BeerDiaryEditorActivity.createIntent(this, diaryId))
    }
  }

  override fun onResume() {
    super.onResume()

    if (diaryId == 0L) {
      binding.image.load(R.drawable.placeholder)
    } else {
      viewModel.get(diaryId)
    }
  }

  private fun initObserver() {
    viewModel.isSuccess.observe(this, Observer {
      if (it) {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
        finish()
      } else {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
      }
    })

    viewModel.diary.observe(this, Observer {
      binding.title.text = it.title
      binding.content.text = it.content
      binding.rating.rating = it.starCount
      url = it.url
      binding.image.load(File(url)) {
        placeholder(R.drawable.placeholder)
        error(R.drawable.placeholder)
      }
    })
  }

  private fun hideKeyboard() {
    val inputMethodManager =
      getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(
      currentFocus?.windowToken,
      InputMethodManager.HIDE_NOT_ALWAYS
    )
  }

  companion object {
    private const val IMAGE_SELECT_REQUEST_CODE = 1

    private const val DIARY_ID = "MEMORY_ID"

    fun createIntent(context: Context): Intent = Intent(context, BeerDetailActivity::class.java)

    fun createIntent(context: Context, id: Long): Intent =
      Intent(context, BeerDetailActivity::class.java).apply {
        putExtra(DIARY_ID, id)
      }
  }
}
