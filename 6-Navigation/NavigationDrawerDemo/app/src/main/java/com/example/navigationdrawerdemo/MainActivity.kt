package com.example.navigationdrawerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawer : DrawerLayout
    lateinit var navigationView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar : Toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        var actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar,
        R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment_message()).commit()
            navigationView.setCheckedItem(R.id.new_message)
        }
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
        super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

    }
}