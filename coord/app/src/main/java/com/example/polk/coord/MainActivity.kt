package com.example.polk.coord

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.jetbrains.anko.doAsync


class MainActivity : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    //private var btnshow: Button? = null
   // private var text_show: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

         findViewById<Button>(R.id.btn_show).setOnClickListener {
            checkLocation()
        }


    }

    @SuppressLint("SetTextI18n")
     fun checkLocation() {

        val task = fusedLocationProviderClient.lastLocation


        if (ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                    101
            )

            return
        }


        task.addOnSuccessListener {
            if (it != null) {
                println("${it.latitude} ${it.longitude}")

                doAsync {
                    findViewById<TextView>(R.id.text_show).text = "${it.longitude} ${it.latitude}"
                }

                Toast.makeText(this, "${it.longitude} ${it.latitude}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
