package com.example.qrscanner

import com.example.qrscanner.data.ScanEntity
import com.example.qrscanner.helper.ScanMapper
import com.example.qrscanner.room.ScanDAO
import com.example.qrscanner.room.ScanDataBase
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.Mockito.`when`

@RunWith(RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest = Config.NONE)
class ScanEntityUnitTest {

    @get:Rule
    val rule = MockitoJUnit.rule()

    @Mock
    val scanDao: ScanDAO? = null

    @Mock
    val scanDB: ScanDataBase? = null


    @Before
    fun setUp() {
        `when`(scanDB!!.getScanDAO()).thenReturn(scanDao)
    }

    @Test
    fun testScanEntityWasAddedToDB() {
        val entity = ScanEntity("12", "blabla", 125668999)
        val id = scanDao?.addScan(entity)
        assertNotNull(id)

    }
}