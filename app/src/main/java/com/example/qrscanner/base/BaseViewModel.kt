package com.example.qrscanner.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel(), KoinComponent, CoroutineScope {

    private var jobList = ArrayList<Job>()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    fun addJob(job: Job) {
        if (!jobList.contains(job))
            jobList.add(job)
    }

    override fun onCleared() {
        super.onCleared()
        jobList.forEach { job ->
            job.apply {
                if (!job.isCancelled and (job.isActive or !job.isCompleted))
                    job.cancel()
            }
        }
    }
}