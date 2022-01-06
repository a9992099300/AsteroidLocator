package com.a9992099300.asteroidlocator.home.asteroidList.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_api.domain.usecases.TypeAsteroidUseCase
import com.a9992099300.asteroidsneo.data.NeoFeed
import com.a9992099300.asteroidsneo.data.NeoFeedUI
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AsteroidListViewModelFactory
@Inject constructor (
    private val UIMapper: ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeedUI>>,
    private val typeAsteroidUseCaseImpl: TypeAsteroidUseCase
    // private val asteroidRepository: AsteroidRepository,
)
    : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AsteroidListViewModel::class.java)) {
            return AsteroidListViewModel(//asteroidRepository,
                UIMapper,
                typeAsteroidUseCaseImpl) as T
        } else {
            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
        }
    }
}