package com.a9992099300.asteroidlocator.home.asteroidList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_api.domain.usecases.AsteroidRepository
import com.a9992099300.asteroidlocator.core_impl.dto.NeoFeedDto
import com.a9992099300.asteroidsneo.data.NeoFeed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


class ViewModelAsteroidList (
    private val asteroidRepository: AsteroidRepository,
): ViewModel()  {
    private val _asteroidFlow = MutableStateFlow<ResultAsteroid<NeoFeed>>(ResultAsteroid.Empty)
    val asteroidFlow: StateFlow<ResultAsteroid<NeoFeed>> = _asteroidFlow

    init {
        viewModelScope.launch {
            asteroidRepository.getAsteroid("2015-09-07","2015-09-08")
                .collect {
                    _asteroidFlow.value = it
                }
        }
    }
}
