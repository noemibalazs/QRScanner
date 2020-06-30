package com.example.qrscanner.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.qrscanner.R
import com.example.qrscanner.data.Scan
import com.example.qrscanner.databinding.ItemHistoryBinding
import com.example.qrscanner.helper.DebounceClickListener
import com.example.qrscanner.helper.HistoryClickListener
import com.example.qrscanner.history.HistoryViewModel
import com.example.qrscanner.util.convertLongToDate

class HistoryVH(
    val binding: ItemHistoryBinding,
    val historyViewModel: HistoryViewModel,
    val historyClickListener: HistoryClickListener?
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(scan: Scan) {
        val context = binding.root.context
        binding.viewModel = historyViewModel
        binding.apply {
            tvScanText.text = context.getString(R.string.txt_scan_text, scan.text)
            tvScanDate.text =
                context.getString(R.string.txt_scan_date, scan.timeStamp.convertLongToDate())

            clContainer.setOnClickListener(object : DebounceClickListener() {
                override fun onDebounce(view: View) {
                    historyClickListener?.onHistoryClicked(scan.text)
                }
            })
        }
    }
}