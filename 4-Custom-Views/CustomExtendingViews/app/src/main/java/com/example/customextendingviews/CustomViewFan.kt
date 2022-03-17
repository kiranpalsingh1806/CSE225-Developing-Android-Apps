package com.example.customextendingviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class CustomViewFan(context: Context?) : View(context) {
    lateinit var p: Paint
    var x = 100
    fun init() {
        p = Paint()
    }

//    override fun onDraw(canvas: Canvas?) {
//        canvas.drawColor(Color.RED)
//        p.color = Color.YELLOW
//        canvas.drawRect(108f, 108f, 500f, 500f)
//        p.color = Color.GREEN
//        canvas.drawArc()
//    }
}