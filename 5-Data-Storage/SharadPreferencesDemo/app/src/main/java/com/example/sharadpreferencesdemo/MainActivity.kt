package com.example.sharadpreferencesdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var sharedpreferences : SharedPreferences
    lateinit var name : TextView
    lateinit var email : TextView
    lateinit var status : TextView
    val mypreference = "mypref"
    val Name = "nameKey"
    val Email = "emailKey"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        name = findViewById(R.id.etName)
        email = findViewById(R.id.etEmail)
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)

        if(sharedpreferences.contains(Name)) {
            name.text = sharedpreferences.getString(Name, "")
        }

        if(sharedpreferences.contains(Email)) {
            email.text = sharedpreferences.getString(Email, "")
        }
    }

    fun signup(view : View?) {
        val n = name.text.toString()
        val e = email.text.toString()
        val editor = sharedpreferences.edit()
        editor.putString(Name, n)
        editor.putString(Email, e)
        editor.commit()
    }

    fun login(view : View) {
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)

        if(sharedpreferences.contains(Name) && sharedpreferences.contains(Email)) {
            status.text = "You are logged in successfully !!!"
        } else {
            status.text = "Dear User, something is wrong :("
        }
    }
}