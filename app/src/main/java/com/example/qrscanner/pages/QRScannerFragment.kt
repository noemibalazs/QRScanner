package com.example.qrscanner.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.qrscanner.R
import com.example.qrscanner.ui.ScanResultActivity
import com.example.qrscanner.util.openActivity
import com.google.zxing.Result
import kotlinx.android.synthetic.main.fragment_qr_scanner.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

class QRScannerFragment : Fragment(), ZXingScannerView.ResultHandler {

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
            context?.openActivity(ScanResultActivity::class.java)
        }
    }

    override fun onPause() {
        super.onPause()
        zxing_scanner_view.stopCamera()
    }
}