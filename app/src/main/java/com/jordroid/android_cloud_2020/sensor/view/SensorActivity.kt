package com.jordroid.android_cloud_2020.sensor.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jordroid.android_cloud_2020.R
import com.jordroid.android_cloud_2020.sensor.model.AccelerometerValue
import com.jordroid.android_cloud_2020.sensor.viewmodel.SensorViewModel
import kotlinx.android.synthetic.main.activity_sensor.*

class SensorActivity : AppCompatActivity() {

    private lateinit var mViewModel: SensorViewModel
    private var mObserverAccelerometer = Observer<AccelerometerValue> {
        updateUi(it)
    }

    private var mObserverLuminosity = Observer<Float> {
        updateUiLuminosity(it)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)
        mViewModel = ViewModelProvider(this)[SensorViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        mViewModel.accelerometerMutableLiveData.observe(this, mObserverAccelerometer)
        mViewModel.luminosityMutableLiveData.observe(this, mObserverLuminosity)
    }

    override fun onStop() {
        mViewModel.accelerometerMutableLiveData.removeObserver(mObserverAccelerometer)
        mViewModel.luminosityMutableLiveData.removeObserver(mObserverLuminosity)
        super.onStop()
    }

    private fun updateUi(accelerometerValue: AccelerometerValue){
        sensor_x.text = getString(R.string.accelerometer_value_x, accelerometerValue.axeX)
        sensor_y.text = getString(R.string.accelerometer_value_y, accelerometerValue.axeY)
        sensor_z.text = getString(R.string.accelerometer_value_z, accelerometerValue.axeZ)
    }

    private fun updateUiLuminosity(lux : Float) {
        text_light.text = lux.toString()
    }
}