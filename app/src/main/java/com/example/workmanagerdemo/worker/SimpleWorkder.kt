package com.example.workmanagerdemo.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.ananananzhuo.mvvm.utils.logEE

class SimpleWorkder(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
       logEE("哈哈哈哈")
        return Result.success()
    }
}