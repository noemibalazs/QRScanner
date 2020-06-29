package com.example.qrscanner.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.qrscanner.data.ScanEntity

@Database(entities = [ScanEntity::class], version = 1, exportSchema = false)
abstract class ScanDataBase : RoomDatabase() {

    abstract fun getScanDAO(): ScanDAO
}