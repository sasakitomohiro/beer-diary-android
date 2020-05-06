package monster.sasakisan.beer_diary_android.util

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

fun <T : ViewDataBinding> ComponentActivity.bindView(): T =
  DataBindingUtil.bind(getContentView())!!

private fun Activity.getContentView(): View = findViewById<ViewGroup>(android.R.id.content)[0]

fun <T : ViewDataBinding> Fragment.bindView(): T = DataBindingUtil.bind(view!!)!!
