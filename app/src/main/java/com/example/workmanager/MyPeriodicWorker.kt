package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyPeriodicWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    companion object{
        private const val TAG = "MyPeriodicWorker"
    }

    override fun doWork(): Result {
        Log.d(TAG,"Work is done")
        return Result.success()
    }
}