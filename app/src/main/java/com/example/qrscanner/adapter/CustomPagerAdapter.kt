package com.example.qrscanner.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.qrscanner.R
import com.example.qrscanner.pages.HistoryFragment
import com.example.qrscanner.pages.QRScannerFragment

class CustomPagerAdapter(
    private val context: Context,
    private val fragmentManager: FragmentManager
) :
    FragmentStatePagerAdapter(
        fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> QRScannerFragment()
        else -> HistoryFragment()
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.app_name)
        else -> context.getString(R.string.txt_history)
    }
}