package com.a9992099300.asteroidlocator.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.a9992099300.asteroidlocator.main.databinding.ActivityMainBinding
import com.a9992099300.asteroidlocator.main_navigation.NavigationFlow
import com.a9992099300.asteroidlocator.main_navigation.Navigator
import com.a9992099300.asteroidlocator.main_navigation.ToFlowNavigatable
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), ToFlowNavigatable {
    //NavigationView.OnNavigationItemSelectedListener
    private lateinit var binding: ActivityMainBinding

    private val navigator: Navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        navController.apply {
            navigator.navController = this
            binding.navView.setupWithNavController(this)
        }

//        navigator.navController = navController
//        binding.navView.setupWithNavController(navController)

        setView()
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }

    private fun setView() {
        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout,
            binding.activityContent.tollbar, R.string.open, R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.to_asteroid_locator -> {
                    this.navigateToFlow(NavigationFlow.AsteroidListFlow)
                    true
                }
                R.id.to_photo_asteroid -> {
                    TODO()
                }
                R.id.to_grap_asteroid_locator -> {
                    TODO()
                }
                R.id.setting -> {
                    TODO()
                }
                R.id.about_app -> {
                    TODO()
                }
                else -> false
            }
                .also {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }

        }


    }


//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.to_asteroid_locator ->{
//                this.navigateToFlow(NavigationFlow.AsteroidListFlow)
//            }
//            R.id.to_photo_asteroid ->{
//
//            }
//            R.id.to_grap_asteroid_locator ->{
//
//            }
//            R.id.setting ->{
//
//            }
//            R.id.about_app ->{
//
//            }
//        }
//        binding.drawerLayout.closeDrawer(GravityCompat.START)
//        return true
//    }

}

