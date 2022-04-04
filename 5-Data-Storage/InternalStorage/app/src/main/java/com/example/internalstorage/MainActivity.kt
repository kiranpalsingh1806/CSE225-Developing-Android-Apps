package com.example.internalstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var b1:Button
    lateinit var b2: Button
    lateinit var tv: TextView
    lateinit var etName : EditText
    lateinit var etAge : EditText
    lateinit var etEmail : EditText
    lateinit var nameData: String
    lateinit var ageData: String
    lateinit var emailData: String
    private val file =  "kiranpaldata.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        b1 = findViewById(R.id.button)
        b2 = findViewById(R.id.button2)
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etEmail = findViewById(R.id.etEmail)
        tv = findViewById(R.id.textView2)

        b1.setOnClickListener {
            nameData = etName.text.toString()
            ageData = etAge.text.toString()
            emailData = etEmail.text.toString()

            try {
                val fOut = openFileOutput(file, MODE_APPEND)

                fOut.write(nameData.toByteArray())
                fOut.write(ageData.toByteArray())
                fOut.write(emailData.toByteArray())

                fOut.close()
                Toast.makeText(baseContext, "File Saved", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        b2.setOnClickListener {
            try {
                val fin = openFileInput(file)
                var c : Int
                var temp = ""
                while(fin.read().also {c = it} != -1) {
                    temp += c.toChar().toString() + " "
                }
                tv.text = temp
                Toast.makeText(baseContext, "File Read", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {

            }
        }
    }
}