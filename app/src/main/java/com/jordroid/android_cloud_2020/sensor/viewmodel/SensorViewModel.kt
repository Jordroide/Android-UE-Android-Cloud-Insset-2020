package com.jordroid.android_cloud_2020.sensor.viewmodel

import androidx.lifecycle.ViewModel
import com.jordroid.android_cloud_2020.sensor.repository.SensorRepository

class SensorViewModel : ViewModel() {

    private val mSensorRepository by lazy { SensorRepository() }
    val accelerometerMutableLiveData = mSensorRepository.accelerometerMutableLiveData
    val luminosityMutableLiveData = mSensorRepository.luminosityMutableLiveData
}