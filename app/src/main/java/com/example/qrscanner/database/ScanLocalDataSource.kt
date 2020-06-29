package com.example.qrscanner.database

import com.example.qrscanner.data.ScanEntity

interface ScanLocalDataSource {

    fun addScanEntity2DB(scanEntity: ScanEntity)

    fun getScanByID(id:String): ScanEntity

    fun getAllScans(): MutableList<ScanEntity>

    fun deleteScan(scanEntity: ScanEntity)
}