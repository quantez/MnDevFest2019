package com.aandtech.navcomponent

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.ui.NavigationUI.setupWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var lifecycleObserver: LifecycleObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(this, R.id.nav_host_fragment)
        setupWithNavController(bottomNavigation, navController)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)


        // MyLifeCycle() is one of my classes
        lifecycle.addObserver(MyLifeCycle())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun showBottomNav(show: Boolean) {
        when (show) {
            true -> bottomNavigation.visibility = View.VISIBLE
            false -> bottomNavigation.visibility = View.INVISIBLE
        }
    }


    // This doesn't do anything functional, just shows the difference between also, let, apply and run.
    class MyLifeCycle : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun resume() {
            val data1 = Data1(9,5)
            val data2 = data1.copy(y = 0)
            val r: Data = Data()?.also {
                it.x = 4
            }
            val z: Int = Data()?.let {
                it.x
            }
            val z1: Data = Data()?.apply {
                x = 4
            }
            val z2: Unit = Data()?.run {
                x = 4
            }
        }

    }

    data class Data1(val x: Int, val y: Int)

    class Data {
        var x = 0
        val y = 1
    }

}
