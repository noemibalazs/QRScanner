package com.example.qrscanner.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.example.qrscanner.R
import com.example.qrscanner.adapter.CustomPagerAdapter
import com.example.qrscanner.base.BaseActivity
import com.example.qrscanner.base.BaseViewModel
import com.example.qrscanner.util.PERMISSION_CODE
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.core.logger.KOIN_TAG

class MainActivity : BaseActivity<BaseViewModel>() {

    override fun initViewModel(): BaseViewModel {
        return ViewModelProviders.of(this).get(BaseViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        if (!checkPermission()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                PERMISSION_CODE
            )
        }
    }

    private fun initView() {
        vp_main.adapter = CustomPagerAdapter(this, supportFragmentManager)
        tl_main.setupWithViewPager(vp_main)
    }

    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            applicationContext,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Logger.d(KOIN_TAG, "onRequestPermissionResult: permission is granted")
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                PERMISSION_CODE
            )
        }
    }
}