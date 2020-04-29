package monster.sasakisan.beer_diary_android.ui.home

import coil.api.load
import com.xwray.groupie.databinding.BindableItem
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.ItemBeerBinding
import monster.sasakisan.beer_diary_android.model.Diary
import monster.sasakisan.beer_diary_android.ui.beerdetail.BeerDetailActivity
import java.io.File

class BeerItem(
  val diary: Diary
) : BindableItem<ItemBeerBinding>() {
  override fun getLayout(): Int = R.layout.item_beer

  override fun bind(viewBinding: ItemBeerBinding, position: Int) {
    viewBinding.title.text = diary.title
    viewBinding.image.load(File(diary.url)) {
      placeholder(R.drawable.placeholder)
      error(R.drawable.placeholder)
    }
    viewBinding.ratingBar.rating = diary.starCount

    val context = viewBinding.root.context
    viewBinding.root.setOnClickListener {
      context.startActivity(BeerDetailActivity.createIntent(context, diary.id))
    }
  }

  override fun getSpanSize(spanCount: Int, position: Int): Int {
    return 1
  }
}
