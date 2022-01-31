package com.a9992099300.asteroidlocator.home.asteroidList.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCase
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
import com.a9992099300.asteroidsneo.data.NeoFeed
import com.a9992099300.asteroidsneo.data.NeoFeedUI
import javax.inject.Inject


//internal class AsteroidList2ViewModelFactory
//@Inject constructor (
//    private val UIMapper: ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeedUI>>,
//    private val loadAsteroidsUseCase: LoadAsteroidsUseCase,
//)
//    : ViewModelProvider.Factory{
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(AsteroidList2ViewModel::class.java)) {
//            return AsteroidList2ViewModel(//asteroidRepository,
//                UIMapper,
//                loadAsteroidsUseCase,
//            ) as T
//        } else {
//            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
//        }
//    }
//}