package com.a9992099300.setting

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.setting.databinding.FragmentSettingBinding
import com.a9992099300.setting.di.DaggerSettingComponent
import com.a9992099300.setting.vm.SettingViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val TAG = "debug"

class SettingsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SettingViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentSettingBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerSettingComponent
            .builder()
            .providersFacade(
                (activity?.application as AppWithFacade)
                    .getFacade()
            )
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(
            inflater, container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadPreference()
        setView()

        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            viewModel.saveThemePreference(isChecked)
            setTheme(isChecked)
        }
    }

    private fun setView() {
        lifecycleScope.launchWhenStarted {
            viewModel.preferred
                .onEach {
                    binding.switchTheme.isChecked = it.theme
                }
                .collect()
        }
    }

    private fun setTheme(blackTheme: Boolean) {
        val currentMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (blackTheme) {
            if (currentMode != Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                requireActivity().recreate()
            } else return
        } else {
            if (currentMode != Configuration.UI_MODE_NIGHT_NO) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                requireActivity().recreate()
            } else return
        }
    }
}