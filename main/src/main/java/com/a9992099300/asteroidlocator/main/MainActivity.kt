package com.a9992099300.asteroidlocator.main

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import com.a9992099300.asteroidlocator.main.R
import com.a9992099300.asteroidlocator.main_navigation.NavigationFlow
import com.a9992099300.asteroidlocator.main_navigation.Navigator
import com.a9992099300.asteroidlocator.main_navigation.ToFlowNavigatable

class MainActivity : AppCompatActivity(), ToFlowNavigatable {

      private val navigator: Navigator = Navigator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navigator.navController = navController
      //  Log.d("TAG","NAVCONTROLLER: ${navigator.navController.toString()}")

        navView.setupWithNavController(navController)
    }


    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }
}