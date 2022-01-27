package com.a9992099300.asteroidlocator.home.asteroidList.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.entities.Language
import com.a9992099300.asteroidlocator.main.usecase.LoadAppPreferenceUseCaseImpl
import com.a9992099300.asteroidsneo.data.NeoFeedUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
const val TAG = "debug"

internal class MainActivityViewModel (
    private val loadAppPreferenceUseCase: LoadAppPreferenceUseCaseImpl
): ViewModel()  {

    private val _preferred = MutableStateFlow(AppPreference(false,Language.DEFAULT))
    val preferred: StateFlow<AppPreference> = _preferred

    init {
        viewModelScope.launch {
                _preferred.value = loadAppPreferenceUseCase()
                Log.d(TAG, "preference viewmodel ${_preferred.value} ")
            }
        }

}

