package com.a9992099300.asteroidlocator.home.asteroidList.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.utils.Open
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
import com.a9992099300.asteroidsneo.data.NeoFeed
import com.a9992099300.asteroidsneo.data.NeoFeedUI
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@Open
class AsteroidListViewModelFactory
@Inject constructor (
    private val UIMapper: ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeedUI>>,
    private val loadAsteroidsUseCase: LoadAsteroidsUseCase,
    private val nearEarthObjectMapper: ModelMapper<NearEarthObject, NearEarthObjectUI>,
    private val saveDeleteAsteroidsUseCase: SaveDeleteAsteroidsUseCase,
    private val ioCoroutineDispatcher: CoroutineDispatcher,
): ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AsteroidListViewModel::class.java)) {
            return AsteroidListViewModel(//asteroidRepository,
                UIMapper,
                loadAsteroidsUseCase,
                nearEarthObjectMapper,
                saveDeleteAsteroidsUseCase,
                ioCoroutineDispatcher
            ) as T
        } else {
            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
        }
    }
}