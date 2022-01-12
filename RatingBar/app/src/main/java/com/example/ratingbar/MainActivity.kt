package com.example.ratingbar

import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleRatingBar = findViewById<RatingBar>(R.id.simpleRatingBar)
        val simpleRating = findViewById<RatingBar>(R.id.simpleRatingBar2)
        val submitBtn = findViewById<Button>(R.id.submitBtn);

        submitBtn.setOnClickListener {
            val totalStars = "Total Stars : " + simpleRatingBar.numStars
            val rating = "Rating : " + simpleRatingBar.rating
            Toast.makeText(this, """$totalStars $rating""".trimIndent(), Toast.LENGTH_LONG).show()
        }

        simpleRating.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener {
                ratingBar: RatingBar ?, rating: Float, fromUser : Boolean ->
            Toast.makeText(this, "Rating $rating", Toast.LENGTH_LONG).show()
        }
    }
}