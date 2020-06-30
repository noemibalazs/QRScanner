package com.example.qrscanner.helper

import com.example.qrscanner.data.Scan
import com.example.qrscanner.data.ScanEntity

class ScanMapper {

    fun mapEntityToScan(scanEntity: ScanEntity): Scan {
        return Scan(scanEntity.id, scanEntity.text, scanEntity.timeStamp)
    }

    fun mapScanToEntity(scan: Scan): ScanEntity {
        return ScanEntity(scan.id, scan.text, scan.timeStamp)
    }
}