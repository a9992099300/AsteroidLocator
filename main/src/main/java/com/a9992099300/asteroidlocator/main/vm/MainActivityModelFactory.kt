package com.a9992099300.asteroidlocator.main.vm


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.home.asteroidList.vm.MainActivityViewModel
import com.a9992099300.domain_preference.usecase.LoadAppPreferenceUseCaseImpl
import javax.inject.Inject


internal class MainActivityModelFactory @Inject constructor (
    private val loadAppPreferenceUseCase: LoadAppPreferenceUseCaseImpl
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(
                loadAppPreferenceUseCase
            ) as T
        } else {
            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
        }
    }
}