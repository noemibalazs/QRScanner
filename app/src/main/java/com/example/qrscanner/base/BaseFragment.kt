package com.example.qrscanner.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM: BaseViewModel> : Fragment() {

    private var viewModel: VM? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = initViewModel()
    }

    abstract fun initViewModel(): VM
}