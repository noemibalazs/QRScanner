package com.example.qrscanner.history

import com.example.qrscanner.base.BaseViewModel
import com.example.qrscanner.database.ScanRepository
import com.example.qrscanner.helper.DataManager

class HistoryViewModel(
    val scanRepository: ScanRepository,
    val dataManager: DataManager
) : BaseViewModel() {

}