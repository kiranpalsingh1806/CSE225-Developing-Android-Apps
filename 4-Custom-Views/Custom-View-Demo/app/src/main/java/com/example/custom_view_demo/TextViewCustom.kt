package com.example.custom_view_demo

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TextViewCustom : AppCompatTextView {
    private var title : String? = null
    private var color = false;

    constructor(context : Context) : super(context) {}
    constructor(context : Context, attrs : AttributeSet) : super(context, attrs) {
        val tarry : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewCustom)
        try {
            title = tarry.getString(R.styleable.TextViewCustom_settitle)
            if(title == null) {
                setText("Custom Message")
            } else {
                setText("Hello")
            }

            color = tarry.getBoolean(R.styleable.TextViewCustom_setColor, false)
            if(color) {
                setTextColor(Color.MAGENTA)
            }
        }
        finally {
            tarry.recycle()
        }
    }
}