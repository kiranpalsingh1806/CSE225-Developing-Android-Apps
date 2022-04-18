package com.example.swipeexample

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.swipeexample.ui.login.LoginFragment

class SimpleFragmentPagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager) {
    override fun getCount(): Int {
        return 4
    }

    override  fun getItem(position : Int) : Fragment {
        return if(position == 0) {
            Fragment1()
        } else if(position == 1) {
            Fragment2()
        } else if(position == 2) {
            LoginFragment()
        } else {
            Fragment3()
        }
    }
}
