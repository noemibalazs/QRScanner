package com.example.qrscanner.helper

import android.content.Context
import com.example.qrscanner.util.SCAN_KEY
import com.example.qrscanner.util.SCAN_PREFERENCE

class DataManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences(SCAN_PREFERENCE, Context.MODE_PRIVATE)

    fun saveScanID(scanID: String) {
        sharedPreferences.edit().putString(SCAN_KEY, scanID).apply()
    }

    fun getScanID(): String {
        return sharedPreferences.getString(SCAN_KEY, "") ?: ""
    }
}