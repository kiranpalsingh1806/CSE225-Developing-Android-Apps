package com.example.dynamic_fragments


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(),OnDataListener {
    var sendData = ""
    var sendData2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()

        if(savedInstanceState != null) {
            sendData2 = savedInstanceState.getString("K1")!!
        }

        val displaymode = resources.configuration.orientation
        if(displaymode == 1) {
            val f1 = FirstFragment()
            fragmentTransaction.replace(android.R.id.content, f1)
        } else {
            val f2 = SecondFragment()
            fragmentTransaction.replace(android.R.id.content, f2)
            if(sendData2 != null) {
                f2.displayReceivedData(sendData2)
            }
        }
        fragmentTransaction.commit()
    }

    override fun communicate(msg : String) {
        sendData = msg
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("K1", sendData)
    }
}