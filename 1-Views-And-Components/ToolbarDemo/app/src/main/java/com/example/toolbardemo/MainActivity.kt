package com.example.toolbardemo

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import android.widget.Toolbar
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btnSetAlarm: Button
    lateinit var timePicker: TimePicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        timePicker = findViewById(R.id.timePicker)
        btnSetAlarm = findViewById(R.id.buttonAlarm)
        btnSetAlarm.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    timePicker.hour,
                    timePicker.minute,
                    0
                )
            } else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    timePicker.currentHour,
                    timePicker.currentMinute, 0
                )
            }
            setAlarm(calendar.timeInMillis)
        }


        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setTitle("Toolbar")
        toolbar.setLogo(R.drawable.img_3)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Back Arrow", Toast.LENGTH_LONG).show()
        }
    }

    private fun setAlarm(timeInMillis: Long) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, MyAlarm::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC,
            timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show()
    }
    private class MyAlarm : BroadcastReceiver() {
        override fun onReceive(
            context: Context,
            intent: Intent
        ) {
            Log.d("Alarm Bell", "Alarm just fired")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.itemId
        if(id == R.id.action_email) {
            Toast.makeText(applicationContext, "Email", Toast.LENGTH_SHORT).show()
            return true
        } else if(id == R.id.action_alert) {
            Toast.makeText(applicationContext, "Alert", Toast.LENGTH_SHORT).show()
            return true
        } else if(id == R.id.action_info) {
            Toast.makeText(applicationContext, "Info", Toast.LENGTH_SHORT).show()
            return true
        } else if(id == R.id.setting1) {
            Toast.makeText(applicationContext, "Setting 1", Toast.LENGTH_SHORT).show()
            return true
        } else if(id == R.id.setting2) {
            Toast.makeText(applicationContext, "Setting 2", Toast.LENGTH_SHORT).show()
            return true
        } else if(id == R.id.setting3) {
            Toast.makeText(applicationContext, "Setting 3", Toast.LENGTH_SHORT).show()
            return true
        } else if(id == R.id.exit) {
            Toast.makeText(applicationContext, "Exit", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}