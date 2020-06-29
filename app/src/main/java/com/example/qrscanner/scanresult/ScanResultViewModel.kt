package com.example.qrscanner.scanresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.qrscanner.base.BaseViewModel
import com.example.qrscanner.base.SingleLiveEvent
import com.example.qrscanner.data.ScanEntity
import com.example.qrscanner.database.ScanRepository
import com.example.qrscanner.helper.DataManager
import com.orhanobut.logger.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.logger.KOIN_TAG

class ScanResultViewModel(
    val scanRepository: ScanRepository,
    val dataManager: DataManager
) : BaseViewModel() {

    val onSearchClicked = SingleLiveEvent<Any>()
    private var _mutableScanResult = MutableLiveData<ScanEntity>()
    val mutableScanResult: LiveData<ScanEntity>
        get() = _mutableScanResult

    init {
        getScanResult()
    }

    private fun getScanResult(){
        val job = launch {
            val result = scanRepository.getScanById(dataManager.getScanID())
            withContext(Dispatchers.Main){
                _mutableScanResult.value = result
            }
        }

        addJob(job)
    }

    fun onSearchClicked() {
        Logger.d(KOIN_TAG, "onSearchClicked")

        onSearchClicked.call()
    }
}