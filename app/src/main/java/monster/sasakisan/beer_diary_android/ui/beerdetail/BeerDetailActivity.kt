package monster.sasakisan.beer_diary_android.ui.beerdetail

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
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
import java.io.File
import java.io.InputStream
import javax.inject.Inject

@RuntimePermissions
class BeerDetailActivity : AppCompatActivity(R.layout.activity_beer_detail), HasAndroidInjector {
  private val binding: ActivityBeerDetailBinding by lazy {
    bindView<ActivityBeerDetailBinding>()
  }

  @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>
  @Inject lateinit var viewModel: BeerDetailViewModel

  private var diaryId = 0L
  private var url = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    initObserver()

    diaryId = intent.getLongExtra(DIARY_ID, 0)

    if (diaryId == 0L) {
      binding.image.load(R.drawable.placeholder)
    } else {
      viewModel.get(diaryId)
    }

    binding.image.setOnClickListener {
      selectPhotoWithPermissionCheck()
    }


    binding.save.setOnClickListener {
      viewModel.add(
        Diary(
          id = diaryId,
          title = binding.title.text.toString(),
          content = binding.content.text.toString(),
          url = url,
          starCount = binding.rating.rating
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

          val docId = DocumentsContract.getDocumentId(uri)
          val split = docId.split(":")
          val type = split[0]
          val contentUri = MediaStore.Files.getContentUri("external")
          val selection = "_id=?"
          val selectionArgs = arrayOf(split[1])
          val proj = arrayOf(MediaStore.Images.Media.DATA)
          contentResolver.query(contentUri, proj, selection, selectionArgs, null)?.use {
            if (it.moveToFirst()) {
              val columnIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
              url = it.getString(columnIndex)
            }
          }

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
        finish()
      } else {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
      }
    })

    viewModel.diary.observe(this, Observer {
      binding.title.setText(it.title)
      binding.content.setText(it.content)
      url = it.url

      binding.image.load(File(url)) {
        placeholder(R.drawable.placeholder)
        error(R.drawable.placeholder)
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
