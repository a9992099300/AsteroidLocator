//package com.a9992099300.asteroidlocator.home.asteroidList.vm
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.a9992099300.asteroidlocator.core_api.UI.UIState
//import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
//import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
//import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCase
//import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCase
//import com.a9992099300.asteroidlocator.home.asteroidList.usecase.TypeList
//import com.a9992099300.asteroidsneo.data.NearEarthObject
//import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
//import com.a9992099300.asteroidsneo.data.NeoFeed
//import com.a9992099300.asteroidsneo.data.NeoFeedUI
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.InternalCoroutinesApi
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.launch
//const val TAG = "debug"
//
//internal class AsteroidList2ViewModel (
//    private val UIMapper: ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeedUI>>,
//    private val loadAsteroidsUseCase: LoadAsteroidsUseCase,
//): ViewModel()  {
//    private val _asteroidFlow = MutableStateFlow<UIState<NeoFeedUI>>(UIState.ShowLoading)
//    val asteroidFlow: StateFlow<UIState<NeoFeedUI>> = _asteroidFlow
//
//
//    fun loadAsteroids(startDate: String, endDate: String, typeList: TypeList) {
//        viewModelScope.launch {
//                    loadAsteroidsUseCase(startDate,endDate,typeList)
//                .collect {
//                    _asteroidFlow.value = UIMapper.mapToExternalLayer(it)
//                }
//        }
//    }
//
//}
//
//
