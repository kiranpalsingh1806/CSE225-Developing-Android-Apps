package com.example.fragments_exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.core.graphics.toColorInt
import com.example.fragments_exercise.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etColr = findViewById<EditText>(R.id.etColr);
        var btnfrag1 =findViewById<Button>(R.id.btnfrag1);
        var cardFrag1 = findViewById<CardView>(R.id.cardFrag1);
        var cardFrag2 = findViewById<CardView>(R.id.cardFrag2);
        var btnfrag2 =findViewById<Button>(R.id.btnfrag2);

        btnfrag1.setOnClickListener(){
           var tex = etColr.text.toString();
            cardFrag1.background.setTint(tex.toColorInt());
        }
        btnfrag2.setOnClickListener(){
            var tex = etColr.text.toString();
            cardFrag2.background.setTint(tex.toColorInt());
        }
    }
}