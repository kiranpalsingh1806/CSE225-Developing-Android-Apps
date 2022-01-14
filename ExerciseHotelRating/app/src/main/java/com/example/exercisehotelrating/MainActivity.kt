package com.example.exercisehotelrating

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import kotlin.math.floor
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SplashScreen::class.java)
            startActivity(intent)
            finish()}, 100)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, RatingActivity::class.java)
            startActivity(intent)
            finish()}, 6000)
    }
}