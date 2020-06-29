package com.example.qrscanner.util

import android.content.Context
import android.content.Intent

fun Context.openActivity(destination: Class<*>) {
    startActivity(Intent(this, destination))
}