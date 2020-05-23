package com.mebill.functionsgenericlibrary

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import android.R.attr.data
import java.text.NumberFormat

private val df_date = SimpleDateFormat("dd/MM/yyyy")
private val df_date_day_month_name = SimpleDateFormat("dd/MMM")
private val df_date_day_month = SimpleDateFormat("dd/MM")
private val df_date_hour_minute_secondes = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
private val df_string_to_date = SimpleDateFormat("yyyy/dd/MM HH:mm:ss")
private val numberFormat = NumberFormat.getNumberInstance(Locale("pt", "BR"))

private val ptBr = Locale("pt", "BR")
private val moneyFormat = NumberFormat.getCurrencyInstance(ptBr)

fun Date.getDateFormated(): String? {
    return try {
        df_date.format(this.time)
    } catch (ex: Exception){
        ex.printStackTrace()
        null
    }
}

fun Date.getDayMonthNameFormated(): String? {
    return try {
        df_date_day_month_name.format(time)
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}

fun Date.getDayMonthFormated(): String? {
    return try {
        df_date_day_month.format(time)
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}

fun Date.getDateHourMinuteSecondsFormated(): String? {
    return try {
        return df_date_hour_minute_secondes.format(time)
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}

fun String.getHourFormated(): String? {
    return try {
        val date = df_string_to_date.parse(this)
        df_date_hour_minute_secondes.format(date!!)

    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}

fun Int?.convertToNumber(): String? {
    return try {
        val numberFomated = numberFormat.format(this ?: 0)
        numberFomated
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}

fun Double?.convertToMoney(): String? {
    return try {
        val numberFomated = moneyFormat.format(this ?: 0)
        numberFomated
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}
