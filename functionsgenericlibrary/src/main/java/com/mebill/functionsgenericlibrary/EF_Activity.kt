package com.mebill.functionsgenericlibrary

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Build
import android.os.Build.MANUFACTURER
import android.os.Build.MODEL
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.util.TypedValue
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

const val REQUEST_PERMISSION_LOCATION = 101

fun Activity.setTranslucentStatusBar(){
    window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }
}

fun Activity.vibratePhone(){
    try {
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            //deprecated in API 26
            v.vibrate(500)
        }
    } catch (ex: Exception) {
        Log.e("TAG_VIBRATE_PHONE", ex.message)
//                ex.printStackTrace()
    }
}

fun Context.pxTodp(dp_p: Int): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp_p.toFloat(), resources.displayMetrics).toInt()
}

fun Context.deviceIsOnline(): Boolean {

    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    //should check null because in airplane mode it will be null
    return netInfo != null && netInfo.isConnected
}

fun Activity.setColorStatusBar(color : Int){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(color)
    }
}

@SuppressLint("DefaultLocale")
fun Any.getDeviceName(): String =
    (if (MODEL.startsWith(MANUFACTURER, ignoreCase = true)) {
        MODEL
    } else {
        "$MANUFACTURER $MODEL"
    }).capitalize()

fun Context.isPermissionLocationAlow() : Boolean{
    return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
}
fun Activity.requestPermissionLocation(){
    ActivityCompat.requestPermissions(this , arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),REQUEST_PERMISSION_LOCATION)
}