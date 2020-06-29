package com.example.qrscanner.di

import org.koin.core.module.Module

class KoinInjection {

    companion object {

        fun injectModules(): MutableList<Module> {
            fun getScanDaoModule() = listOf(scanDAOModule)

            fun getDataManagerModule() = listOf(dataManagerModule)

            return mutableListOf<Module>().apply {
                addAll(getScanDaoModule())
                addAll(getDataManagerModule())
            }
        }
    }
}