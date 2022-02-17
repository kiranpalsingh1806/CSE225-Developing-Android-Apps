package com.example.progressbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import io.github.muddz.styleabletoast.StyleableToast

class MainActivity : AppCompatActivity() {
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar1 = findViewById<ProgressBar>(R.id.progressBar1)
        val progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)
        val textView1 = findViewById<TextView>(R.id.textView)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnReset = findViewById<Button>(R.id.btnReset)

        progressBar1.visibility = View.INVISIBLE
        progressBar2.visibility = View.INVISIBLE

        btnShow.setOnClickListener {
            progressBar1.visibility = View.VISIBLE
            progressBar2.visibility = View.VISIBLE
            i = progressBar1.progress
            Thread {
                while(i < 100) {
                    i = i + 1
                    Handler(Looper.getMainLooper()).post{
                        progressBar1.progress = i
                        textView1.setText(i.toString() + "/" + progressBar1.max)
                        if(i == 100) {
                            progressBar1.visibility = View.INVISIBLE
                            progressBar2.visibility = View.INVISIBLE
                            StyleableToast.makeText(application, "Completed !!", Toast.LENGTH_LONG, R.style.myToast).show();
                        }
                    }

                    try {
                        Thread.sleep(100);
                    } catch (e : InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }.start()
        }

        btnReset.setOnClickListener {
            progressBar1.progress = 0
            textView1.setText("0 / 100")
        }
    }
}