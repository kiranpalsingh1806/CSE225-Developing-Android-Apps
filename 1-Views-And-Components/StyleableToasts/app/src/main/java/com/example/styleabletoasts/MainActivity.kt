package com.example.styleabletoasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import io.github.muddz.styleabletoast.StyleableToast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            StyleableToast.makeText(
                this,
                "Hello World",
                Toast.LENGTH_SHORT,
                R.style.exampleToast
            ).show()
        }
    }
}