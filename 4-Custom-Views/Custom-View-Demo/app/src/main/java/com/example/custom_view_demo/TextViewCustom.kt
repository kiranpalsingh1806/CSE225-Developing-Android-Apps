package com.example.custom_view_demo

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.graphics.toColorInt

class TextViewCustom : AppCompatTextView {
    private var title : String? = null
    private var color = false;
    private var italic = false;
    private var allCapital = false;
    private var writeColor : String? = null

    constructor(context : Context) : super(context) {}
    constructor(context : Context, attrs : AttributeSet) : super(context, attrs) {
        val tarry : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewCustom)
        try {
            title = tarry.getString(R.styleable.TextViewCustom_setTitle)
            if(title == null) {
                setText("Custom Message")
            } else {
                setText("Kiranpal Singh")
            }

            writeColor = tarry.getString(R.styleable.TextViewCustom_typeColor)
            if(writeColor == null) {
                setTextColor(Color.BLUE)
            } else {
                Log.i("What is that ?", writeColor.toString())
                setTextColor(writeColor!!.toColorInt())
            }

            color = tarry.getBoolean(R.styleable.TextViewCustom_setColor, false)
            if(color) {
                setTextColor(Color.BLUE)
            }

            italic = tarry.getBoolean(R.styleable.TextViewCustom_setItalic, false)
            if(italic) {
                setTypeface(null , Typeface.ITALIC)
            }

            allCapital = tarry.getBoolean(R.styleable.TextViewCustom_makeAllCapital, false)
            if(allCapital) {
                setText(text.toString().uppercase())
            }

        }
        finally {
            tarry.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}
}