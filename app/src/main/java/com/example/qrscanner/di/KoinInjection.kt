package com.example.qrscanner.di

import org.koin.core.module.Module

class KoinInjection {

    companion object {

        fun injectModules(): MutableList<Module> {
            fun getScanDaoModule() = listOf(scanDAOModule)

            fun getDataManagerModule() = listOf(dataManagerModule)

            fun getScanModule() = listOf(scanModule)

            fun getScanViewModel() = listOf(scanViewModel)

            fun getScanResultViewModel() = listOf(scanResultViewModel)

            fun getHistoryViewModel() = listOf(historyViewModel)

            return mutableListOf<Module>().apply {
                addAll(getScanDaoModule())
                addAll(getDataManagerModule())
                addAll(getScanModule())
                addAll(getScanViewModel())
                addAll(getScanResultViewModel())
                addAll(getHistoryViewModel())
            }
        }
    }
}