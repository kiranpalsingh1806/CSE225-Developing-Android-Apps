package com.example.customviewdrawing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var customViewDrawing: CustomViewDrawing;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customViewDrawing = CustomViewDrawing(this)
        setContentView(customViewDrawing)
    }
}