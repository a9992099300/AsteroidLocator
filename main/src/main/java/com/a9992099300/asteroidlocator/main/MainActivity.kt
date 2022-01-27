package com.a9992099300.asteroidlocator.main

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.asteroidlocator.home.asteroidList.vm.MainActivityViewModel
import com.a9992099300.asteroidlocator.main.databinding.ActivityMainBinding
import com.a9992099300.asteroidlocator.main.di.DaggerMainComponent
import com.a9992099300.asteroidlocator.main_navigation.NavigationFlow
import com.a9992099300.asteroidlocator.main_navigation.Navigator
import com.a9992099300.asteroidlocator.main_navigation.ToFlowNavigatable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val TAG = "debug"

class MainActivity : AppCompatActivity(), ToFlowNavigatable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private val navigator: Navigator = Navigator()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerMainComponent
            .builder()
            .providersFacade(
                (application as AppWithFacade)
                    .getFacade())
            .build()
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        setNavController()
        setTheme()
        setView()
    }

    private fun setNavController() {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.apply {
            navigator.navController = this
            binding.navView.setupWithNavController(this)
        }
    }

    private fun setTheme() {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

        lifecycleScope.launchWhenStarted {
            viewModel.preferred
                .onEach {
                    if (it.theme) {
                        if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
                            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                            ActivityCompat.recreate(this@MainActivity)
                        }
                    } else {
                        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            ActivityCompat.recreate(this@MainActivity)
                        }
                    }
                }
                .collect()
        }
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
                    this.navigateToFlow(NavigationFlow.AsteroidGraphFlow)
                    true
                }
                R.id.setting -> {
                    this.navigateToFlow(NavigationFlow.SettingFlow)
                    true
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
}

