package com.jordroid.android_cloud_2020.sensor.repository

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.MutableLiveData
import com.jordroid.android_cloud_2020.architecture.CustomApplication
import com.jordroid.android_cloud_2020.sensor.model.AccelerometerValue

class SensorRepository : SensorEventListener {

    private val mSensorManager by lazy {
        CustomApplication.instance.applicationContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    private lateinit var mAccelerometerSensor: Sensor
    private lateinit var mAccelerometerValue: AccelerometerValue
    private lateinit var mLuminositySensor: Sensor
    private var mLuminosityValue: Float = 0f
    val accelerometerMutableLiveData = MutableLiveData<AccelerometerValue>()
    val luminosityMutableLiveData = MutableLiveData<Float>()

    init {
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            mAccelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            mSensorManager.registerListener(
                this,
                mAccelerometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            mLuminositySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
            mSensorManager.registerListener(
                this,
                mLuminositySensor,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        if (sensorEvent?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            mAccelerometerValue = AccelerometerValue(
                sensorEvent.values[0],
                sensorEvent.values[1],
                sensorEvent.values[2]
            )
            accelerometerMutableLiveData.postValue(mAccelerometerValue)
        }

        if(sensorEvent?.sensor?.type == Sensor.TYPE_LIGHT) {
            mLuminosityValue = sensorEvent.values[0]
            luminosityMutableLiveData.postValue(mLuminosityValue)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Do what you want when accuracy changed for a given sensor
    }
}