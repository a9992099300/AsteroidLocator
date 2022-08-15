package com.a9992099300.setting.vm


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.main.usecase.SaveAppPreferenceUseCaseImpl
import com.a9992099300.domain_preference.usecase.LoadAppPreferenceUseCaseImpl
import javax.inject.Inject


internal class SettingModelFactory
@Inject constructor (
    private val saveAppPreferenceUseCase: SaveAppPreferenceUseCaseImpl,
    private val loadAppPreferenceUseCase: LoadAppPreferenceUseCaseImpl
)
    : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingViewModel::class.java)) {
            return SettingViewModel(
                saveAppPreferenceUseCase,
                loadAppPreferenceUseCase
            ) as T
        } else {
            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
        }
    }
}