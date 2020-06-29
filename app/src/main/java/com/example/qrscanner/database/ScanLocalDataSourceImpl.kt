package com.example.qrscanner.database

import com.example.qrscanner.data.ScanEntity
import com.example.qrscanner.room.ScanDAO
import com.orhanobut.logger.Logger
import org.koin.core.logger.KOIN_TAG

class ScanLocalDataSourceImpl(private val scanDAO: ScanDAO) : ScanLocalDataSource {

    override fun addScanEntity2DB(scanEntity: ScanEntity) {
        Logger.d(KOIN_TAG, "addScanEntity2DB: scan entity was added to data base")
        scanDAO.addScan(scanEntity)
    }

    override fun getScanByID(id: String): ScanEntity {
        Logger.d(KOIN_TAG, "getScanByID: id = $id")
        return scanDAO.getScanByID(id)
    }

    override fun getAllScans(): MutableList<ScanEntity> {
        Logger.d(KOIN_TAG, "getAllScans size is: ${scanDAO.getAllScans().size}")
        return scanDAO.getAllScans()
    }

    override fun deleteScan(scanEntity: ScanEntity) {
        Logger.d(KOIN_TAG, "deleteScan: scanEntity was deleted")
        scanDAO.deleteScan(scanEntity)
    }
}