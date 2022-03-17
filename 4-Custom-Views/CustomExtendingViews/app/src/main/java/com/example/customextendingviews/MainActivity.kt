package com.example.customextendingviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
//    lateinit var customViewFan: CustomViewFan
    lateinit var customDrawing: CustomDrawing
//    lateint var customViewDrawing: CustomViewDrawing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customDrawing = CustomDrawing(this)
        setContentView(customDrawing)
    }
}