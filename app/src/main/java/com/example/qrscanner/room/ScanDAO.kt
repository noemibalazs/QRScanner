package com.example.qrscanner.room

import android.content.Context
import androidx.room.*
import com.example.qrscanner.data.ScanEntity
import com.example.qrscanner.util.SCAN_DATA_BASE

@Dao
interface ScanDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addScan(scanEntity: ScanEntity)

    @Delete
    fun deleteScan(entity: ScanEntity)

    @Query("SELECT * FROM SCAN_TABLE")
    fun getAllScans(): MutableList<ScanEntity>

    @Query("SELECT * FROM SCAN_TABLE WHERE id = :id")
    fun getScanByID(id: String): ScanEntity

    companion object {

        fun getDaoInstance(context: Context): ScanDAO {
            return Room.databaseBuilder(context, ScanDataBase::class.java, SCAN_DATA_BASE).build()
                .getScanDAO()
        }
    }

}