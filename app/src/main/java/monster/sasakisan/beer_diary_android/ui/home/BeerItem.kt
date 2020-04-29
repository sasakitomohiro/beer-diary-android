package monster.sasakisan.beer_diary_android.ui.home

import coil.api.load
import com.xwray.groupie.databinding.BindableItem
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.ItemBeerBinding
import monster.sasakisan.beer_diary_android.ui.beerdetail.BeerDetailActivity

class BeerItem(
  val title: String,
  val imageUrl: String
) : BindableItem<ItemBeerBinding>() {
  override fun getLayout(): Int = R.layout.item_beer

  override fun bind(viewBinding: ItemBeerBinding, position: Int) {
    viewBinding.title.text = title
    viewBinding.image.load(imageUrl) {
      placeholder(R.drawable.placeholder)
      error(R.drawable.placeholder)
    }

    val context = viewBinding.root.context
    viewBinding.root.setOnClickListener {
      context.startActivity(BeerDetailActivity.createIntent(context))
    }
  }

  override fun getSpanSize(spanCount: Int, position: Int): Int {
    return 1
  }
}
