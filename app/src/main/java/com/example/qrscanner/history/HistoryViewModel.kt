package com.example.qrscanner.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.qrscanner.base.BaseViewModel
import com.example.qrscanner.data.Scan
import com.example.qrscanner.database.ScanRepository
import com.example.qrscanner.helper.ScanMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryViewModel(
    val scanRepository: ScanRepository,
    val scanMapper: ScanMapper
) : BaseViewModel() {

    private val _mutableScanList = MutableLiveData<MutableList<Scan>>()
    val mutableScanList: LiveData<MutableList<Scan>>
        get() = _mutableScanList

    init {
        getAllScannedResult()
    }

    private fun getAllScannedResult() {
        val mutableScanList = mutableListOf<Scan>()
        val job = launch {
            val result = scanRepository.getAllScanEntity()
            withContext(Dispatchers.Main) {
                result.map { scanEntity ->
                    val scan = scanMapper.mapEntityToScan(scanEntity)
                    mutableScanList.add(scan)
                }
                _mutableScanList.value = mutableScanList
            }
        }

        addJob(job)
    }

    fun deleteScanEntityFromDataBase(scan: Scan) {
        val job = launch {
            val entity = scanMapper.mapScanToEntity(scan)
            scanRepository.deleteScanEntity(entity)
            withContext(Dispatchers.Main) {
                getAllScannedResult()
            }
        }
        addJob(job)
    }
}