package com.example.customextendingviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class CustomDrawing(context: Context?) : View(context) {
    lateinit var p: Paint
    var x:Int =  30
    init {
        init()
    }

    private fun init() {
        p = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        if (canvas != null) {
            canvas.drawColor(Color.BLUE)
        }
        p.color = Color.RED
        if (canvas != null) {
            canvas.drawRect(108f, 108f, 500f, 500f, p)
        }

        p.color = Color.MAGENTA
        if(canvas!= null) {
            canvas.drawCircle(550f, 1000f, 400f, p)
        }

        p.color = Color.YELLOW
        if(canvas!= null) {
            canvas.drawCircle(550f, 1000f, 200f, p)
        }

//        x = 230
//        if (canvas != null) {
//            canvas.drawArc(180f, 600f, 1000f, 1000f, x.toFloat(), 80f, true, p)
//        }
//
//        x = 30
//        if (canvas != null) {
//            canvas.drawArc(180f, 800f, 1000f, 500f, x.toFloat(), 80f, true, p)
//        }
    }
}