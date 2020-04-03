package com.mebill.functionsgenericlibrary

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import android.R.attr.data
import java.text.NumberFormat


private val df_date_hour_minute_secondes = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
private val df_string_to_date = SimpleDateFormat("yyyy/dd/MM HH:mm:ss")
private val numberFormat = NumberFormat.getNumberInstance(Locale("pt", "BR"))


fun Date?.getHourFormated(): String? {
    this?.let {
        return df_date_hour_minute_secondes.format(time)
    }
    return null
}

fun String?.getHourFormated(): String? {
    this?.let {
        try {
            val date = df_string_to_date.parse(it)
            return df_date_hour_minute_secondes.format(date!!)

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    return null
}

fun Int?.convertToMoney() : String?{
    return try {
        val numberFomated = "${numberFormat.format(this?:0)}"
        numberFomated
    }catch (ex : Exception){
        null
    }
}