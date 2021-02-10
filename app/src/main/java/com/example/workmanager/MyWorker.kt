package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context : Context, params : WorkerParameters) : Worker(context,params) {

    companion object{
        private const val TAG = "MyWorker"
    }

    override fun doWork(): Result {
        val  number1 = 10
        val number2 = 20
        val sum = number1.plus(number2)

        Log.d(TAG,sum.toString())
        return Result.success()
    }
}