package com.jordroid.android_cloud_2020.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordroid.android_cloud_2020.R
import kotlinx.android.synthetic.main.activity_recycler_item_details.*

class DetailItemRecycler : AppCompatActivity() {

    var versionName : String? = "UNDEFINED"
    var versionCode : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_item_details)

        versionName = intent?.extras?.getString("versionName")
        versionCode = intent?.extras?.getInt("versionCode")

        detailItemVersionName.text = versionName
        detailItemVersionCode.text = versionCode.toString()
    }
}