package com.example.custom_view_demo

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.TypedArrayUtils

class EditTextCustom(context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs) {
    private var sethint: String? = null;
    private var setcolor = false

    var darkButton: Drawable? = null
    var lightButton:Drawable? = null

    fun init() {
        darkButton = ResourcesCompat.getDrawable(resources, R.drawable.ic_clear_black_24dp, null)
        lightButton = ResourcesCompat.getDrawable(resources, R.drawable.ic_clear_black_22dp, null)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                showButton()
                show()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    fun show() {
        setOnTouchListener { view, motionEvent ->
            var isClicked:Boolean = false

            val clearButtonStart = (width - paddingEnd - darkButton!!.intrinsicWidth).toFloat()
            if(motionEvent.x  > clearButtonStart) {
                isClicked = true
            }

            if(isClicked) {
                when(motionEvent.action) {
                    MotionEvent.ACTION_DOWN->text!!.clear()
                    MotionEvent.ACTION_UP->hideButton()
                }
            }
            true
        }
    }

    fun showButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, darkButton, null)
    }

    fun hideButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,  null, lightButton, null)
    }

    init {
        val tarry1: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.EditTextCustom)
        try {
            sethint = tarry1.getString(R.styleable.EditTextCustom_setHint)

            if(sethint == null) {
                setHint("Enter your message")
            } else {
                setHint("Enter your message here")
            }

            setcolor = tarry1.getBoolean(R.styleable.EditTextCustom_setColor1, false)

            if(setcolor == true) {
                setTextColor(Color.RED)
            }
        }
        finally {
            tarry1.recycle()
            init()
        }
    }


}