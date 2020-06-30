package com.example.qrscanner.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.qrscanner.R
import com.example.qrscanner.data.Scan
import com.example.qrscanner.databinding.ItemHistoryBinding
import com.example.qrscanner.helper.HistoryClickListener
import com.example.qrscanner.helper.HistoryDiffUtil
import com.example.qrscanner.history.HistoryViewModel

class HistoryAdapter(private val historyViewModel: HistoryViewModel) :
    ListAdapter<Scan, HistoryVH>(HistoryDiffUtil()) {

    var clickListener: HistoryClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryVH {
        val binding: ItemHistoryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_history,
            parent,
            false
        )
        return HistoryVH(binding, historyViewModel, clickListener)
    }

    override fun onBindViewHolder(holder: HistoryVH, position: Int) {
        holder.onBind(getItem(position))
    }

    fun removeListener() {
        clickListener = null
    }
}