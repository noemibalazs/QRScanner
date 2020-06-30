package com.example.qrscanner.qrscanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qrscanner.R
import com.example.qrscanner.base.BaseFragment
import com.example.qrscanner.database.ScanViewModel
import com.example.qrscanner.helper.DataManager
import com.example.qrscanner.scanresult.ScanResultActivity
import com.example.qrscanner.util.openActivity
import com.google.zxing.Result
import kotlinx.android.synthetic.main.fragment_qr_scanner.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.koin.android.ext.android.inject

class FragmentQRScanner : BaseFragment<ScanViewModel>(), ZXingScannerView.ResultHandler {

    private val dataManager: DataManager by inject()
    private val scanViewModel: ScanViewModel by inject()

    override fun initViewModel(): ScanViewModel = scanViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_qr_scanner, container, false)
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView() {
        zxing_scanner_view.setResultHandler(this)
        zxing_scanner_view.startCamera()
    }

    override fun handleResult(result: Result?) {
        result?.let {
            scanViewModel.addScan2DB(it.text)
            context?.openActivity(ScanResultActivity::class.java)
        }
    }

    override fun onPause() {
        super.onPause()
        zxing_scanner_view.stopCamera()
    }
}