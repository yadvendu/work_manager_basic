package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chainWorkRequest()
    }

    private fun oneTimeWorkRequest() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
    }

    private fun periodicWorkRequest() {
        val periodicWorkRequest = PeriodicWorkRequest.Builder(
            MyPeriodicWorker::class.java,
            20, TimeUnit.MINUTES
        )
            .build()

        WorkManager.getInstance(this).enqueue(periodicWorkRequest)
    }

    private fun chainWorkRequest() {
        val oneTimeWorkRequestA = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .build()

        val oneTimeWorkRequestB = OneTimeWorkRequest.Builder(MyPeriodicWorker::class.java)
            .build()

        val oneTimeWorkRequestC = OneTimeWorkRequest.Builder(MyWorker2::class.java)
            .build()

        /**
         * To chain more than oneTimeWorkRequest
         */
        WorkManager.getInstance(this)
            .beginWith(oneTimeWorkRequestA)
            .then(oneTimeWorkRequestB)
            .enqueue()

        /**
         * To start more than one work at same time
         * and then chain it with another work request
         */
//        val list = listOf<OneTimeWorkRequest>(oneTimeWorkRequestA, oneTimeWorkRequestB)
//        WorkManager.getInstance(this)
//            .beginWith(list)
//            .then(oneTimeWorkRequestC)
//            .enqueue()
    }
}