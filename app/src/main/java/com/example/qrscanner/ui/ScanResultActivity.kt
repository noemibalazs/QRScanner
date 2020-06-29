package com.example.qrscanner.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qrscanner.R
import com.example.qrscanner.util.openActivity
import kotlinx.android.synthetic.main.activity_scan_result.*

class ScanResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_result)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        openActivity(MainActivity::class.java)
    }
}