package com.example.customextendingviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
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

    override fun onDraw(canvas: Canvas) {
//        if (canvas != null) {
//            canvas.drawColor(Color.BLUE)
//        }
//        p.color = Color.RED
//        if (canvas != null) {
//            canvas.drawRect(108f, 108f, 500f, 500f, p)
//        }
//
//        p.color = Color.MAGENTA
//        if(canvas!= null) {
//            canvas.drawCircle(550f, 1000f, 400f, p)
//        }
//
//        p.color = Color.YELLOW
//        if(canvas!= null) {
//            canvas.drawCircle(550f, 1000f, 200f, p)
//        }

        canvas.drawColor(Color.RED)
        p.color = Color.YELLOW
        canvas.drawRect(108f, 108f, 500f, 500f, p)
        p.color = Color.GREEN
        canvas.drawArc(500f, 500f, 800f, 800f, (x).toFloat(), 30f, true, p)
        canvas.drawArc(500f, 500f, 800f, 800f, (x + 90).toFloat(), 30f, true, p)
        canvas.drawArc(500f, 500f, 800f, 800f, (x + 180).toFloat(), 30f, true, p)
        canvas.drawArc(500f, 500f, 800f, 800f, (x + 270).toFloat(), 30f, true, p)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        for(i in 0..50000) {
            if (event != null) {
                when(event.action) {
                    MotionEvent.ACTION_DOWN ->startFan()
                    MotionEvent.ACTION_UP ->stopFan()
                }
            }
        }
        return true
    }

    fun stopFan() {
    }

    fun startFan() {
        x = x + 10
        invalidate()
        // invalidate means redraw on screen and results to a call of the view's onDraw() method
    }

    init {
        init()
    }

}