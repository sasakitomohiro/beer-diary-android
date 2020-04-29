package monster.sasakisan.beer_diary_android.ui.home

import com.xwray.groupie.databinding.BindableItem
import monster.sasakisan.beer_diary_android.R
import monster.sasakisan.beer_diary_android.databinding.ItemSettingBinding

class SettingItem(
  val title: String,
  private val onCheckedChange: (Boolean) -> Unit
) : BindableItem<ItemSettingBinding>() {
  override fun getLayout(): Int = R.layout.item_setting

  override fun bind(viewBinding: ItemSettingBinding, position: Int) {
    viewBinding.title.text = title
    viewBinding.switchButton.setOnCheckedChangeListener { _, isChecked ->
      onCheckedChange(isChecked)
    }
  }
}
