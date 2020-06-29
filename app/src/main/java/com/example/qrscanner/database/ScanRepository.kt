package com.example.qrscanner.database

import com.example.qrscanner.data.ScanEntity

class ScanRepository(private val scanLocalDataSource: ScanLocalDataSource) {

    fun getScanById(id: String) = scanLocalDataSource.getScanByID(id)

    fun addScanToDataBase(scanEntity: ScanEntity) = scanLocalDataSource.addScanEntity2DB(scanEntity)

    fun getAllScanEntity() = scanLocalDataSource.getAllScans()

    fun deleteScanEntity(scanEntity: ScanEntity) = scanLocalDataSource.deleteScan(scanEntity)
}