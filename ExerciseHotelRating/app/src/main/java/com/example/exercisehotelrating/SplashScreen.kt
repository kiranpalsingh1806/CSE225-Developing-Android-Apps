package com.example.exercisehotelrating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val logo = findViewById<ImageView>(R.id.logo)
        val appName = findViewById<ImageView>(R.id.app_name)
        val splashImage = findViewById<ImageView>(R.id.img)
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.lottie)

        splashImage.animate().translationY(-2200f).setDuration(1000).setStartDelay(4000)
        logo.animate().translationY(1800f).setDuration(1000).setStartDelay(4000)
        appName.animate().translationY(1800f).setDuration(1000).setStartDelay(4000)

        val animationView:LottieAnimationView = findViewById(R.id.lottie)
        animationView.setAnimation(R.raw.splash)
        animationView.playAnimation()
    }
}