package com.example.qrscanner.util

import android.content.Context
import android.content.Intent
import java.text.SimpleDateFormat
import java.util.*

fun Context.openActivity(destination: Class<*>) {
    startActivity(Intent(this, destination))
}

fun Long.convertLongToDate(): String {
    val sdf = SimpleDateFormat("dd MMMM, yyyy - hh:mm", Locale.getDefault())
    val date = Date(this)
    return sdf.format(date)
}