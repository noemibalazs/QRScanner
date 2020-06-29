package com.example.qrscanner.di

import com.example.qrscanner.helper.DataManager
import com.example.qrscanner.room.ScanDAO
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val scanDAOModule = module {
    single { ScanDAO.getDaoInstance(androidApplication().applicationContext) }
}

val dataManagerModule = module {
    single { DataManager(androidApplication().applicationContext) }
}