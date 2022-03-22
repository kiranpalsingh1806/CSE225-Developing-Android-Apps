package com.example.customviewdrawing

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.graphics.BitmapFactory

import android.graphics.Bitmap




class CustomViewDrawing(context: Context?) : View(context) {
    lateinit var p: Paint
    lateinit var mpath: Path
    lateinit var rectangle : Rect
    lateinit var clearButton :Button
    var mask = BitmapFactory.decodeResource(resources, R.drawable.img)
    var x: Int = 30

    init {
        init()
    }

    private fun init() {
        p = Paint()
        mpath = Path()
        p.color = Color.WHITE
        p.style = Paint.Style.STROKE
        p.strokeWidth = 10f
        rectangle = Rect(700,700,900,900)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.GRAY)
        canvas.drawPath(mpath, p)
        canvas.drawBitmap(mask, null, rectangle, null)
    }

    fun clear() {
        mpath.reset()
        postInvalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            when(event.action) {
                MotionEvent.ACTION_DOWN -> mpath.moveTo(event.x, event.y)
                MotionEvent.ACTION_MOVE -> mpath.lineTo(event.x, event.y)
                MotionEvent.ACTION_UP ->
                {
                    var x = event.x
                    var y = event.y
                    if((x in 705.0..895.0) && (y in 705.0..895.0))
                    {
                        mpath.reset()
                    }
                }
            }
        }
        invalidate()
        return true
    }

    init {
        init()
    }
}