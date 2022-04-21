package com.example.swipeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_tab_example)

        val viewPager = findViewById<View>(R.id.view_pager) as ViewPager
        val adapter = SimpleFragmentPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter
    }
}