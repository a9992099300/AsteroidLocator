package com.a9992099300.asteroidlocator.home.asteroidList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_api.domain.usecases.AsteroidRepository
import com.a9992099300.asteroidlocator.core_impl.dto.NeoFeedDto
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AsteroidListViewModelFactory @Inject constructor(
    private val asteroidRepository: AsteroidRepository,
    private val resultMapper: ModelMapper<NeoFeed, NeoFeedDto>
): ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelAsteroidList::class.java)) {
            return ViewModelAsteroidList(asteroidRepository, resultMapper) as T
        } else {
            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
        }
    }
}