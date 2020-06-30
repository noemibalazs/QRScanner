package com.example.qrscanner.data

data class Scan(
    val id: String,
    val text: String,
    val timeStamp: Long
) {
    override fun toString(): String {
        return "Scan: id='$id', text='$text', timeStamp=$timeStamp"
    }
}