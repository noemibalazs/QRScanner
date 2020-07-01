package com.example.qrscanner

import com.example.qrscanner.helper.DataManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest = Config.NONE)
class DataManagerUnitTest {

    private var dataManager: DataManager? = null
    private val ID = "12-DF-69"

    @Before
    fun setUp() {
        dataManager = DataManager(RuntimeEnvironment.application.applicationContext)
    }

    @Test
    fun testSaveId(){
        dataManager?.saveScanID(ID)
        val id = dataManager?.getScanID()
        Assert.assertEquals(id, ID)
    }
}