package com.example.qrscanner.helper

import com.example.qrscanner.data.Scan

interface HistoryClickListener {

    fun onHistoryClicked(scanText: String)

    fun onLongClickedToDelete(scan: Scan)
}