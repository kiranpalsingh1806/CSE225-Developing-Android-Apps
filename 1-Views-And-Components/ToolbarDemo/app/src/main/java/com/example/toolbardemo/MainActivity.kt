package com.example.toolbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setTitle("Toolbar")
        toolbar.setLogo(R.drawable.img_3)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Back Arrow", Toast.LENGTH_LONG).show()
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