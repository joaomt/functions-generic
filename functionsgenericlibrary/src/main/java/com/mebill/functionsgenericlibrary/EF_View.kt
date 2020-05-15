package com.mebill.functionsgenericlibrary

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.ImageViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

fun View.closeSoftInput() {
    this.context?.let{
        val imm = it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.hideSoftInputFromWindow(this.windowToken, 0)
    }
}
fun FloatingActionButton.setColorStateListCustom(color: Int) {
    ImageViewCompat.setImageTintList(
        this,
        ColorStateList.valueOf(color)
    )
}
