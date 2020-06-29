package com.example.qrscanner.scanresult

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.qrscanner.R
import com.example.qrscanner.base.BaseActivity
import com.example.qrscanner.database.ScanViewModel
import com.example.qrscanner.databinding.ActivityScanResultBinding
import com.example.qrscanner.ui.MainActivity
import com.example.qrscanner.util.openActivity
import org.koin.android.ext.android.inject

class ScanResultActivity : BaseActivity<ScanResultViewModel>() {

    private val viewModel: ScanResultViewModel by inject()
    private lateinit var binding: ActivityScanResultBinding

    override fun initViewModel(): ScanResultViewModel = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scan_result)

        initBinding()
        setObservers()
    }

    private fun initBinding() {
        binding.viewModel = viewModel
    }

    private fun setObservers() {
        viewModel.mutableScanResult.observe(this, Observer {
            binding.tvContentText.text = it.text
        })

        viewModel.onSearchClicked.observe(this, Observer {
            searchOnGoogle()
        })

    }

    private fun searchOnGoogle() {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.apply {
            putExtra(SearchManager.QUERY, binding.tvContentText.text)
        }
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        openActivity(MainActivity::class.java)
    }
}