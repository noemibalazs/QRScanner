package com.example.qrscanner

import com.example.qrscanner.data.Scan
import com.example.qrscanner.data.ScanEntity
import com.example.qrscanner.helper.ScanMapper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest = Config.NONE)
class ScanMapperUnitTest {

    @Test
    fun testEntityToScan(){
        val entity = ScanEntity("12", "bla", 12345678)
        val scan = Scan("12", "bla", 12345678)
        val mappedScan = ScanMapper().mapEntityToScan(entity)
        Assert.assertEquals(scan, mappedScan)
    }

    @Test
    fun testScanToEntity(){
        val scanEntity = ScanEntity("12", "bla", 12345678)
        val scan = Scan("12", "bla", 12345678)
        val mappedEntity = ScanMapper().mapScanToEntity(scan)
        Assert.assertEquals(scanEntity, mappedEntity)
    }
}