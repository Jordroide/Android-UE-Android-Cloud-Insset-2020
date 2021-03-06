package com.jordroid.android_cloud_2020.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordroid.android_cloud_2020.R
import com.jordroid.android_cloud_2020.firebase.view.FirebaseLoginActivity
import com.jordroid.android_cloud_2020.sensor.view.SensorActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainButtonActivityIntent.setOnClickListener { goToActivityIntent() }
        mainButtonRecyclerView.setOnClickListener { goToRecyclerView() }
        mainButtonActivityChain.setOnClickListener { goToChainConstraint() }
        mainButtonActivityStrings.setOnClickListener { goToString() }
        mainButtonActivityResource.setOnClickListener { goToResources() }
        mainButtonActivityValuesLand.setOnClickListener { goToValuesLand() }
        mainButtonActivityPermission.setOnClickListener { goToPermission() }
        mainButtonActivityFirebase.setOnClickListener { goToFirebase() }
        mainButtonActivitySensor.setOnClickListener { goToSensor() }
    }

    /**
     * Redirect to the new activity
     */
    private fun goToActivityIntent() {
        startActivity(Intent(this, FirstActivity::class.java))
    }

    private fun goToRecyclerView() {
        startActivity(Intent(this, RecyclerViewActivity::class.java))
    }

    private fun goToChainConstraint() {
        startActivity(Intent(this, ChainConstraintActivity::class.java))
    }

    private fun goToString() {
        startActivity(Intent(this, StringsActivity::class.java))
    }

    private fun goToResources() {
        startActivity(Intent(this, ResourceActivity::class.java))
    }

    private fun goToValuesLand() {
        startActivity(Intent(this, ValuesLandActivity::class.java))
    }

    private fun goToPermission() {
        startActivity(Intent(this, PermissionActivity::class.java))
    }

    private fun goToFirebase() {
        startActivity(Intent(this, FirebaseLoginActivity::class.java))
    }

    private fun goToSensor() {
        startActivity(Intent(this, SensorActivity::class.java))
    }
}