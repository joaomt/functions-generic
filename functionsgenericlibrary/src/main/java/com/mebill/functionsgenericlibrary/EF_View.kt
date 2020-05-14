package com.mebill.functionsgenericlibrary

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.closeSoftInput() {
    this.context?.let{
        val imm = it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.hideSoftInputFromWindow(this.windowToken, 0)
    }
}