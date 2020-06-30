package com.example.qrscanner.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.qrscanner.data.Scan

class HistoryDiffUtil : DiffUtil.ItemCallback<Scan>() {

    override fun areItemsTheSame(oldItem: Scan, newItem: Scan): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Scan, newItem: Scan): Boolean {
        return oldItem.id == newItem.id && oldItem.text == newItem.text &&
                oldItem.timeStamp == newItem.timeStamp
    }
}