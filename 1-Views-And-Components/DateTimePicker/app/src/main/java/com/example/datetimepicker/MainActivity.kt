package com.example.datetimepicker

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker

class MainActivity : AppCompatActivity() {

    lateinit var previewSelectedTimeTextView: TextView

    private val timePickerDialogListener: TimePickerDialog.OnTimeSetListener =
        object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                val formattedTime: String = when {
                    hourOfDay == 0 -> {
                        if (minute < 10) {
                            "${hourOfDay + 12}:0${minute} am"
                        } else {
                            "${hourOfDay + 12}:${minute} am"
                        }
                    }
                    hourOfDay > 12 -> {
                        if (minute < 10) {
                            "${hourOfDay - 12}:0${minute} pm"
                        } else {
                            "${hourOfDay - 12}:${minute} pm"
                        }
                    }
                    hourOfDay == 12 -> {
                        if (minute < 10) {
                            "${hourOfDay}:0${minute} pm"
                        } else {
                            "${hourOfDay}:${minute} pm"
                        }
                    }
                    else -> {
                        if (minute < 10) {
                            "${hourOfDay}:${minute} am"
                        } else {
                            "${hourOfDay}:${minute} am"
                        }
                    }
                }

                previewSelectedTimeTextView.text = formattedTime
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPickTime: Button = findViewById<Button>(R.id.pick_time_button)
        previewSelectedTimeTextView = findViewById<TextView>(R.id.preview_picked_time_textView)

        buttonPickTime.setOnClickListener {
            val timePicker: TimePickerDialog = TimePickerDialog(
                this,timePickerDialogListener, 12, 10, false
            )
            timePicker.show()
        }
    }
}