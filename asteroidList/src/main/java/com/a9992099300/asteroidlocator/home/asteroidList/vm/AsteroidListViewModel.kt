package com.a9992099300.asteroidlocator.home.asteroidList.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.entities.TypeList
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_api.domain.usecases.TypeAsteroidUseCase
import com.a9992099300.asteroidsneo.data.NeoFeed
import com.a9992099300.asteroidsneo.data.NeoFeedUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
const val TAG = "debug"

class AsteroidListViewModel (
  //  private val asteroidRepository: AsteroidRepository,
    private val UIMapper: ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeedUI>>,
    private val typeAsteroidUseCase: TypeAsteroidUseCase
): ViewModel()  {
    private val _asteroidFlow = MutableStateFlow<UIState<NeoFeedUI>>(UIState.ShowLoading)
    val asteroidFlow: StateFlow<UIState<NeoFeedUI>> = _asteroidFlow

    fun loadAsteroids(startDate: String,endDate: String, typeList: TypeList) {
        viewModelScope.launch {
                    typeAsteroidUseCase.getAsteroids(startDate,endDate,typeList)
                .collect {
                    _asteroidFlow.value = UIMapper.mapToExternalLayer(it)
                }
        }
    }


    init {
  //      "2021-09-07","2021-09-08", TypeList.MainList
    }
}

