package monster.sasakisan.beer_diary_android.ui.beerdetail

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import coil.api.load
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.ActivityBeerDetailBinding
import monster.sasakisan.beer_diary_android.model.Diary
import monster.sasakisan.beer_diary_android.util.bindView
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions
import java.io.InputStream
import javax.inject.Inject

@RuntimePermissions
class BeerDetailActivity : AppCompatActivity(R.layout.activity_beer_detail), HasAndroidInjector {
  private val binding: ActivityBeerDetailBinding by lazy {
    bindView<ActivityBeerDetailBinding>()
  }

  @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>
  @Inject lateinit var viewModel: BeerDetailViewModel

  private var memoryId = 0L
  private var url = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    initObserver()

    memoryId = intent.getLongExtra(DIARY_ID, 0)

    if (memoryId == 0L) {
      binding.image.load(R.drawable.placeholder)
    } else {
//      viewModel
    }

    binding.image.setOnClickListener {
      selectPhotoWithPermissionCheck()
    }


    binding.save.setOnClickListener {
      viewModel.add(
        Diary(
          title = binding.title.text.toString(),
          content = binding.content.text.toString(),
          url = url
        )
      )
    }
  }

  override fun androidInjector(): AndroidInjector<Any> {
    return androidInjector
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode != Activity.RESULT_OK) {
      return
    }
    if (requestCode == IMAGE_SELECT_REQUEST_CODE) {
      var inputStream: InputStream? = null
      try {
        data?.data?.also { uri ->
          url = uri.path ?: ""
          inputStream = contentResolver?.openInputStream(uri)
          val image = BitmapFactory.decodeStream(inputStream)
          binding.image.load(image) {
            placeholder(R.drawable.placeholder)
            error(R.drawable.placeholder)
          }
        }
      } catch (e: Exception) {
      } finally {
        inputStream?.close()
      }
    }
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    onRequestPermissionsResult(requestCode, grantResults)
  }

  @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
  fun selectPhoto() {
    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
      addCategory(Intent.CATEGORY_OPENABLE)
      type = "image/*"
    }
    startActivityForResult(intent, IMAGE_SELECT_REQUEST_CODE)
  }

  private fun initObserver() {
    viewModel.isSuccess.observe(this, Observer {
      if (it) {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
      } else {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
      }
    })
  }

  companion object {
    private const val IMAGE_SELECT_REQUEST_CODE = 1

    private const val DIARY_ID = "MEMORY_ID"

    fun createIntent(context: Context): Intent = Intent(context, BeerDetailActivity::class.java)

    fun createIntent(context: Context, id: Long): Intent = Intent(context, BeerDetailActivity::class.java).apply {
      putExtra(DIARY_ID, id)
    }
  }
}
