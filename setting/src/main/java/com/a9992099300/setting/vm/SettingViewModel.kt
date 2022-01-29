package com.a9992099300.setting.vm


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.entities.Language
import com.a9992099300.asteroidlocator.main.usecase.SaveAppPreferenceUseCaseImpl
import com.a9992099300.domain_preference.usecase.LoadAppPreferenceUseCaseImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

const val TAG = "debug"

internal class SettingViewModel (
    private val saveAppPreferenceUseCase: SaveAppPreferenceUseCaseImpl,
    private val loadAppPreferenceUseCase: LoadAppPreferenceUseCaseImpl
): ViewModel()  {

    private val _preferred = MutableStateFlow(AppPreference(false, Language.DEFAULT))
    val preferred: StateFlow<AppPreference> = _preferred

   fun loadPreference() {
        viewModelScope.launch {
            _preferred.value = loadAppPreferenceUseCase()
        }
    }

    fun saveThemePreference(theme: Boolean){
        viewModelScope.launch {
            saveAppPreferenceUseCase.invoke(theme)
        }
    }

}

