package com.mebill.functionsgenericlibrary

import android.text.TextUtils

fun String.isEmailValid(): Boolean {
    return try{
         !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }catch (ex : Exception) { false }
}