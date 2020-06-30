package com.example.qrscanner.helper

import android.os.SystemClock
import android.view.View
import java.lang.Math.abs
import java.util.*

abstract class DebounceClickListener(private val timeStamp: Long = 900) : View.OnClickListener {

    private val myMap: MutableMap<View, Long>

    init {
        myMap = WeakHashMap<View, Long>()
    }

    abstract fun onDebounce(view: View)

    override fun onClick(view: View) {
        val previousTimeStamp = myMap[view]
        val currentTimeStamp = SystemClock.uptimeMillis()
        myMap[view] = currentTimeStamp
        if (previousTimeStamp == null || abs(currentTimeStamp - previousTimeStamp.toLong()) > timeStamp)
            onDebounce(view)
    }
}