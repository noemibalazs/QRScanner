package com.example.qrscanner.database

import android.os.SystemClock
import com.example.qrscanner.base.BaseViewModel
import com.example.qrscanner.data.ScanEntity
import com.example.qrscanner.helper.DataManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.logger.KOIN_TAG
import java.util.*

class ScanViewModel(
    val scanRepository: ScanRepository,
    val dataManager: DataManager) : BaseViewModel() {

    fun addScan2DB(scanText: String) {

        val job = launch {
            val id = UUID.randomUUID().toString()
            val timeStamp = SystemClock.uptimeMillis()
            val scanEntity = ScanEntity(id = id, text = scanText, timeStamp = timeStamp)
            scanRepository.addScanToDataBase(scanEntity)
            dataManager.saveScanID(id)
            withContext(Dispatchers.Main) {
                com.orhanobut.logger.Logger.d(KOIN_TAG, "scan entity was added 2 db")
            }
        }
        addJob(job)
    }
}