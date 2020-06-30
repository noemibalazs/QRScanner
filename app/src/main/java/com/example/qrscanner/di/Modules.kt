package com.example.qrscanner.di

import com.example.qrscanner.database.ScanLocalDataSource
import com.example.qrscanner.database.ScanLocalDataSourceImpl
import com.example.qrscanner.database.ScanRepository
import com.example.qrscanner.database.ScanViewModel
import com.example.qrscanner.helper.DataManager
import com.example.qrscanner.helper.ScanMapper
import com.example.qrscanner.history.HistoryViewModel
import com.example.qrscanner.room.ScanDAO
import com.example.qrscanner.scanresult.ScanResultViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

val scanDAOModule = module {
    single { ScanDAO.getDaoInstance(androidApplication().applicationContext) }
}

val dataManagerModule = module {
    single { DataManager(androidApplication().applicationContext) }
}

val scanModule = module {

    single<ScanLocalDataSource> {
        ScanLocalDataSourceImpl(scanDAO = get())
    }

    single {
        ScanRepository(scanLocalDataSource = get())
    }
}

val scanViewModel = module {
    viewModel {
        ScanViewModel(scanRepository = get(), dataManager = get())
    }
}

val scanResultViewModel = module {
    viewModel { ScanResultViewModel(scanRepository = get(), dataManager = get()) }
}

val historyViewModel = module {

    factory { ScanMapper() }

    viewModel {
        HistoryViewModel(
            scanRepository = get(),
            scanMapper = get()
        )
    }
}