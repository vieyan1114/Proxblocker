package com.example.proxblocker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private var serviceRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleButton = findViewById<MaterialButton>(R.id.toggleButton)

        toggleButton.setOnClickListener {
            if (serviceRunning) {
                stopService(Intent(this, ScreenOnService::class.java))
                toggleButton.text = "Enable"
            } else {
                startService(Intent(this, ScreenOnService::class.java))
                toggleButton.text = "Disable"
            }
            serviceRunning = !serviceRunning
        }
    }
}
