package com.example.sharedprefernceswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var applyTextButton: Button
    private lateinit var saveButton: Button
    private lateinit var switch1 : Switch
    private lateinit var text: String

    private var switchOnOff = false
    val SHARED_PREFS = "sharedPrefs"
    val TEXT = "text"
    val SWITCH1 = "switch1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textview)
        editText = findViewById(R.id.edittext)
        applyTextButton = findViewById(R.id.apply_text_button)
        saveButton = findViewById(R.id.save_button)
        switch1 = findViewById(R.id.switch1)

        applyTextButton.setOnClickListener {
            textView.text = editText.text.toString()
        }

        saveButton.setOnClickListener {
            saveData()
        }

        loadData()
        updateViews()
    }

    fun saveData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(TEXT, textView.text.toString())
        editor.putBoolean(SWITCH1, switch1.isChecked)
        editor.apply()
        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show()
    }
    fun updateViews() {
        textView.text = text
        switch1.isChecked = switchOnOff
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        text = sharedPreferences.getString(TEXT, "").toString()
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false)
    }
}