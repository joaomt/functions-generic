package com.mebill.functionsgenericlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun View.loadAnim(anim: Int) {
    startAnimation(AnimationUtils.loadAnimation(this.context, anim))
}

fun View.startTranslationY(value: Float, duration: Long) {
    this.animate().translationY(value).setDuration(duration).start()
}

fun View.startTranslationX(value: Float, duration: Long) {
    this.animate().translationX(value).setDuration(duration).start()
}

fun Context.showToastLengthShort(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.showToastLengthLong(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}
@SuppressLint("ResourceAsColor")
fun View.showSnackBar(message:String, colorRes : Int){
    Snackbar.make(this,message,Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.view.setBackgroundColor(colorRes)
        snackbar.setActionTextColor(context.resources.getColor(R.color.colorWhite))
        snackbar.setAction("OK"){
            snackbar.dismiss()
        }
    }.show()
}