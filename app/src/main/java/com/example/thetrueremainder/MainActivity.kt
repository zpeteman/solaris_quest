package com.example.thetrueremainder

import android.app.NotificationChannel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.app.NotificationManager
import android.content.Context
import android.os.Build


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button by its ID
        val button = findViewById<Button>(R.id.button)

        // Set a click listener for the button
        button.setOnClickListener {
            // Create an Intent to start the ChoosingPlanetActivity
            val intent = Intent(this, ChoosingPlanetActivity::class.java)
            // Start the ChoosingPlanetActivity
            startActivity(intent)
        }

        // Create the notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Planets orbit"
            val descriptionText = "this notification channel send the notification of the orbit of the planets arround you, my Quenne!"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("com.example.thetrueremainder.notifications", name, importance).apply {
                description = descriptionText
            }

            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }
}