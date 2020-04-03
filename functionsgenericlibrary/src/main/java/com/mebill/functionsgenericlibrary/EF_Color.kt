package com.mebill.functionsgenericlibrary

import android.R
import android.content.Context
import android.content.res.ColorStateList

fun Context.getColorStateListCustom(color : Int): ColorStateList {
    return ColorStateList(
        arrayOf(intArrayOf(R.attr.state_enabled)),
        intArrayOf(resources.getColor(color))
    )
}