package com.example.qrscanner.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.qrscanner.util.SCAN_TABLE

@Entity(tableName = SCAN_TABLE)
data class ScanEntity(

    val id: String,
    @PrimaryKey
    val text: String,
    val timeStamp: Long
) {
    override fun toString(): String {
        return "ScanEntity: id='$id', text='$text', timeStamp=$timeStamp"
    }
}