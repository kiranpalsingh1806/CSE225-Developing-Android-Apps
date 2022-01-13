package com.example.exercisehotelrating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val rating1 = findViewById<RatingBar>(R.id.rating1)
        val rating2 = findViewById<RatingBar>(R.id.rating2)
        val rating3 = findViewById<RatingBar>(R.id.rating3)
        val rating4 = findViewById<RatingBar>(R.id.rating4)
        val finalRating = findViewById<RatingBar>(R.id.finalRating)
//        val submitBtn = findViewById<Button>(R.id.submitBtn);
        val finalText = findViewById<TextView>(R.id.finalText)

        var average = 0

        fun updateAverage() {
            val totalStars = rating1.rating + rating2.rating + rating3.rating + rating4.rating
            average = floor(totalStars / 4.0).roundToInt()
        }

        fun updateTheText() {
            if(average == 1) {
                finalText.setText("Poor services :(")
            } else if(average == 2) {
                finalText.setText("Not Satisfied")
            } else if(average == 3) {
                finalText.setText("Satisfied")
            } else if(average == 4) {
                finalText.setText("Good Services")
            } else if(average == 5) {
                finalText.setText("Best Services :)")
            }
            Toast.makeText(this, """ Average is $average""".trimIndent(), Toast.LENGTH_SHORT).show()
        }

        rating1.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener {
                ratingBar: RatingBar ?, rating: Float, fromUser : Boolean ->
            finalRating.rating = average.toFloat()
            updateAverage()
            updateTheText()
        }
        rating2.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener {
                ratingBar: RatingBar ?, rating: Float, fromUser : Boolean ->
            finalRating.rating = average.toFloat()
            updateAverage()
            updateTheText()
        }
        rating3.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener {
                ratingBar: RatingBar ?, rating: Float, fromUser : Boolean ->
            finalRating.rating = average.toFloat()
            updateAverage()
            updateTheText()
        }
        rating4.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener {
                ratingBar: RatingBar ?, rating: Float, fromUser : Boolean ->
            finalRating.rating = average.toFloat()
            updateAverage()
            updateTheText()
        }



    }
}