package com.example.custom_view_demo

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TextViewCustom : AppCompatTextView {
    private var title : String? = null
    private var color = false;
    private var italic = false;

    constructor(context : Context) : super(context) {}
    constructor(context : Context, attrs : AttributeSet) : super(context, attrs) {
        val tarry : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewCustom)
        try {
            title = tarry.getString(R.styleable.TextViewCustom_setTitle)
            if(title == null) {
                setText("Custom Message")
            } else {
                setText("Hello")
            }

            color = tarry.getBoolean(R.styleable.TextViewCustom_setColor, false)
            if(color) {
                setTextColor(Color.MAGENTA)
            }

            italic = tarry.getBoolean(R.styleable.TextViewCustom_setItalic, false)
            if(italic) {
                setTypeface(null , Typeface.ITALIC)
            }
        }
        finally {
            tarry.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}
}