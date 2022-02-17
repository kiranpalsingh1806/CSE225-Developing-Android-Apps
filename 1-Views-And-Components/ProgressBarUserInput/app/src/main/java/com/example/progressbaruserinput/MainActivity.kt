package com.example.progressbaruserinput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var progressBar1: ProgressBar
    lateinit var progressBar2: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressBar1 = findViewById<ProgressBar>(R.id.progressBar1)
        progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)
        val textView1 = findViewById<TextView>(R.id.textView)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val userText = findViewById<EditText>(R.id.userText)

        progressBar1.visibility = View.INVISIBLE
        progressBar2.visibility = View.INVISIBLE

        btnShow.setOnClickListener {
            progressBar1.visibility = View.VISIBLE
            progressBar2.visibility = View.VISIBLE
            var i = progressBar1.progress
            Thread {
                while(i < 100) {
                    i = i + 1
                    Handler(Looper.getMainLooper()).post{
                        progressBar1.progress = i
                        textView1.setText(i.toString() + "/" + progressBar1.max)
                        if(i == 100) {
                            progressBar1.visibility = View.INVISIBLE
                            progressBar2.visibility = View.INVISIBLE
                            Toast.makeText(application, "Completed !!", Toast.LENGTH_LONG,).show();
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

        userText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                progressBar1.visibility = View.VISIBLE
                var str = s.toString()
                if (s != null) {
                    if(str.length == 0) {
                        progressBar1.progress = 0
                    } else if(str.length == 1) {
                        progressBar1.progress = 10
                    } else if(str.length == 2) {
                        progressBar1.progress = 20
                    }  else if(str.length == 3) {
                        progressBar1.progress = 30
                    } else if(str.length == 4) {
                        progressBar1.progress = 40
                    } else if(str.length == 5) {
                        progressBar1.progress = 50
                    } else if(str.length == 6) {
                        progressBar1.progress = 60
                    } else if(str.length == 7) {
                        progressBar1.progress = 70
                    } else if(str.length == 8) {
                        progressBar1.progress = 80
                    } else if(str.length == 9) {
                        progressBar1.progress = 90
                    } else if(str.length == 10) {
                        progressBar1.progress = 100
                        Toast.makeText(applicationContext, "You reach at 10 characters", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

}
