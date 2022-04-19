package com.example.tablayoutwithviewpageexercise

import MovieFragment
import android.content.Context;
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs  
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()  
                return HomeFragment()
            }
            1 -> {
                return SportFragment()
            }
            2 -> {
                // val movieFragment = MovieFragment()  
                return MovieFragment()
            }
            else -> return HomeFragment()
        }
    }

    // this counts total number of tabs  
    override fun getCount(): Int {
        return totalTabs
    }
}  
