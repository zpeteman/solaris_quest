package com.example.thetrueremainder

import android.app.NotificationManager
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class JupiterActivity : AppCompatActivity() {

    private lateinit var remainingTimeTextView: TextView
    private val handler = Handler()
    private val updateIntervalMillis = 1000L // Update interval in milliseconds
    private val orbitPeriodMillis = 4333 * 24 * 60 * 60 * 1000L // 225 days in milliseconds


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jupiter) // Set the layout for this activity

        // Find the TextView for displaying the remaining time
        remainingTimeTextView = findViewById(R.id.tm)

        // Start updating the remaining time
        updateRemainingTime()
    }

    private fun updateRemainingTime() {
        // Get the current date
        val currentDate = Calendar.getInstance()

        // Assumed start date of Venus's orbit
        val startDateString = "01/01/2024"
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        try {
            val startDate = dateFormat.parse(startDateString)

            // Calculate the time elapsed since the start date in milliseconds
            val elapsedTimeMillis = currentDate.timeInMillis - startDate!!.time

            // Calculate the remaining time for the current orbit period
            var remainingTimeMillis = orbitPeriodMillis - (elapsedTimeMillis % orbitPeriodMillis)

            // If remaining time is 0, reset the timer
            if (remainingTimeMillis == 0L) {
                remainingTimeMillis = orbitPeriodMillis
            }

            // Convert milliseconds to years, months, days, hours, minutes, and seconds
            val remainingYears = remainingTimeMillis / (1000L * 60 * 60 * 24 * 365)
            // Calculate remaining days after subtracting years
            val remainingDaysAfterYears = remainingTimeMillis % (1000L * 60 * 60 * 24 * 365)

            // Calculate remaining months after subtracting years
            val remainingMonthsAfterYears = remainingDaysAfterYears / (1000L * 60 * 60 * 24) / 30
            // Calculate remaining days after subtracting years and months
            val remainingDaysAfterMonths = remainingDaysAfterYears % (30 * 24 * 60 * 60 * 1000L)

            val remainingDays = remainingDaysAfterMonths / (1000L * 60 * 60 * 24)
            val remainingHours = remainingDaysAfterMonths / (1000L * 60 * 60) % 24
            val remainingMinutes = remainingDaysAfterMonths / (1000L * 60) % 60
            val remainingSeconds = remainingDaysAfterMonths / 1000 % 60

            // Update the TextView with the remaining time
            val remainingTimeString = "$remainingYears y, $remainingMonthsAfterYears m, $remainingDays d, $remainingHours h, $remainingMinutes m, $remainingSeconds s"
            remainingTimeTextView.text = remainingTimeString
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Schedule the next update after the update interval
        handler.postDelayed({ updateRemainingTime() }, updateIntervalMillis)
    }

    override fun onDestroy() {
        // Remove any pending callbacks to prevent memory leaks
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }

    private fun showNotification() {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        NotificationUtils.showNotification(this, "Jupiter Completed Orbit", "Congratulations! Jupiter completed its orbit around you successfully, your Majesty.")
    }
}