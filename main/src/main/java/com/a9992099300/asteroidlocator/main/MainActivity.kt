package com.a9992099300.asteroidlocator.main

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.asteroidlocator.core_api.di.NavigationProvider
import com.a9992099300.asteroidlocator.home.asteroidList.vm.MainActivityViewModel
import com.a9992099300.asteroidlocator.main.databinding.ActivityMainBinding
import com.a9992099300.asteroidlocator.main.di.DaggerMainComponent
import com.a9992099300.asteroidlocator.main_navigation.*
import com.a9992099300.asteroidlocator.main_navigation.di.DaggerNavigatorComponent
import com.a9992099300.asteroidlocator.main_navigation.di.NavigatorComponent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val TAG = "debug"

class MainActivity : AppCompatActivity(), FlowNavigatable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var navigator: NavigatorImpl

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val facade = (application as AppWithFacade).getFacade()

        DaggerMainComponent
            .builder()
            .providersFacade(
                facade
            )
            .navigatorComponent(DaggerNavigatorComponent.builder().providersFacade(facade).build())
            .build()
            .inject(this)

        viewModel.loadThemePreference()
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
                    Log.d(TAG, "main theme ${it.theme}, $currentNightMode")
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
                R.id.to_grap_asteroid_locator -> {
                    this.navigateToFlow(NavigationFlow.AsteroidGraphFlow)
                    true
                }
                R.id.setting -> {
                    this.navigateToFlow(NavigationFlow.SettingFlow)
                    true
                }
                R.id.about_app -> {
                    this.navigateToFlow(NavigationFlow.SettingFlow)
                    true
                }
                else -> false
            }
                .also {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
        }
    }
}

