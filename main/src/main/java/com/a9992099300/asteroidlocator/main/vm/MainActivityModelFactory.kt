package com.a9992099300.asteroidlocator.home.asteroidList.vm


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.main.usecase.LoadAppPreferenceUseCaseImpl
import javax.inject.Inject


internal class MainActivityModelFactory
@Inject constructor (
    private val loadAppPreferenceUseCase: LoadAppPreferenceUseCaseImpl
)
    : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(//asteroidRepository,
                loadAppPreferenceUseCase
            ) as T
        } else {
            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
        }
    }
}