package com.a9992099300.asteroidlocator.home.asteroidList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a9992099300.asteroidlocator.core_api.domain.Result
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_api.domain.usecases.AsteroidRepository
import com.a9992099300.asteroidlocator.core_impl.dto.NeoFeedDto
import com.a9992099300.asteroidsneo.data.NeoFeed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelAsteroidList @Inject constructor(
    private val asteroidRepository: AsteroidRepository,
    private val resultMapper: ModelMapper<NeoFeed, NeoFeedDto>
): ViewModel()  {

    private val _asteroidFlow = MutableStateFlow<Result<NeoFeed>>(Result.Empty)
    val asteroidFlow: StateFlow<Result<NeoFeed>> = _asteroidFlow

//    init {
//        viewModelScope.launch {
//            asteroidRepository.listenForAsteroid()
//                .collect {
//                    _asteroidFlow.value = it
//                }
//        }
//    }
//}
}