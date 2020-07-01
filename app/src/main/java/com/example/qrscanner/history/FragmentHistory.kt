package com.example.qrscanner.history

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.afollestad.materialdialogs.MaterialDialog
import com.example.qrscanner.R
import com.example.qrscanner.adapter.HistoryAdapter
import com.example.qrscanner.base.BaseFragment
import com.example.qrscanner.data.Scan
import com.example.qrscanner.databinding.FragmentHistoryBinding
import com.example.qrscanner.helper.HistoryClickListener
import org.koin.android.ext.android.inject

class FragmentHistory : BaseFragment<HistoryViewModel>() {

    private val historyViewModel: HistoryViewModel by inject()
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: HistoryAdapter

    private val historyClickListener = object : HistoryClickListener {
        override fun onHistoryClicked(scanText: String) {
            searchOnGoogle(scanText)
        }

        override fun onLongClickedToDelete(scan: Scan) {
            shouldDeleteOrNot(scan)
        }
    }

    override fun initViewModel(): HistoryViewModel = historyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
        setObservers()
    }

    private fun searchOnGoogle(scanText: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.apply {
            putExtra(SearchManager.QUERY, scanText)
        }
        startActivity(intent)
    }

    private fun initBinding() {
        binding.viewModel = historyViewModel
        adapter = HistoryAdapter(historyViewModel).apply {
            this.clickListener = historyClickListener
        }
        binding.rvHistory.adapter = adapter
    }

    private fun setObservers() {
        historyViewModel.mutableScanList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun shouldDeleteOrNot(scan: Scan) {
        activity?.let {
            MaterialDialog(it).show {
                title(R.string.txt_do_you_really)
                positiveButton(R.string.txt_ok)
                negativeButton(R.string.txt_cancel)
                negativeButton {
                    dismiss()
                }
                positiveButton {
                    historyViewModel.deleteScanEntityFromDataBase(scan)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter.removeListener()
    }
}