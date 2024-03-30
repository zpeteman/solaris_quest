package com.example.thetrueremainder

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ChoosingPlanetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chosing_planet) // Set the layout for this activity

        // Find the button by its ID
        val button_mercury = findViewById<ImageButton>(R.id.mercuryButton)
        val button_venus = findViewById<ImageButton>(R.id.venusButton)
        val button_earth = findViewById<ImageButton>(R.id.earthButton)
        val button_mars = findViewById<ImageButton>(R.id.marsButton)
        val button_jupiter = findViewById<ImageButton>(R.id.jupiterButton)
        val button_saturn = findViewById<ImageButton>(R.id.saturnButton)
        val button_uranus = findViewById<ImageButton>(R.id.uranusButton)
        val button_neptune = findViewById<ImageButton>(R.id.neptuneButton)

        // Set a click listener for the button
        button_mercury.setOnClickListener {
            val intent = Intent(this, MercuryActivity::class.java)
            startActivity(intent)
        }
        button_venus.setOnClickListener {
            val intent = Intent(this, VenusActivity::class.java)
            startActivity(intent)
        }
        button_earth.setOnClickListener {
            val intent = Intent(this, EarthActivity::class.java)
            startActivity(intent)
        }
        button_mars.setOnClickListener {
            val intent = Intent(this, MarsActivity::class.java)
            startActivity(intent)
        }
        button_jupiter.setOnClickListener {
            val intent = Intent(this, JupiterActivity::class.java)
            startActivity(intent)
        }
        button_saturn.setOnClickListener {
            val intent = Intent(this, SaturnActivity::class.java)
            startActivity(intent)
        }
        button_uranus.setOnClickListener {
            val intent = Intent(this, UranusActivity::class.java)
            startActivity(intent)
        }
        button_neptune.setOnClickListener {
            val intent = Intent(this, NeptuneActivity::class.java)
            startActivity(intent)
        }
    }
}