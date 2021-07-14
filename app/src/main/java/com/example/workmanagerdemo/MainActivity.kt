package com.example.workmanagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.view.recycle.CustomRecyclerView
import com.example.workmanagerdemo.worker.SimpleWorkder
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val datas = mutableListOf<ItemData>(
        ItemData(title = "简单使用",{
            val uploadWorkRequest: WorkRequest =
                OneTimeWorkRequestBuilder<SimpleWorkder>()
                    .build()
            WorkManager
                .getInstance(this)
                .enqueue(uploadWorkRequest)
        }),
        ItemData(title = "延迟3s工作",{
            val myWorkRequest = OneTimeWorkRequestBuilder<SimpleWorkder>()
                .setInitialDelay(3, TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(this).enqueue(myWorkRequest)
        })


    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<CustomRecyclerView>(R.id.recycle).setCustomAdapter(datas)
    }
}