package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker2(context : Context, params : WorkerParameters) : Worker(context,params) {
    companion object{
        private const val TAG = "MyWorker2"
    }

    override fun doWork(): Result {
        Log.d(TAG,"Work is done 2")
        return Result.success()
    }
}