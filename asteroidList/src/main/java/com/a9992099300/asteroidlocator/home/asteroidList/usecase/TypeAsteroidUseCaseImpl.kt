package com.a9992099300.asteroidlocator.home.asteroidList.usecase

import com.a9992099300.asteroidlocator.core_api.data.AsteroidRepository
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.entities.TypeList
import com.a9992099300.asteroidlocator.core_api.domain.usecases.TypeAsteroidUseCase
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@Reusable
class TypeAsteroidUseCaseImpl @Inject constructor(
    private val asteroidRepository: AsteroidRepository,
): TypeAsteroidUseCase {

    override fun getAsteroids(
        startDate: String,
        endDate: String,
        typeList: TypeList
    ): Flow<ResultAsteroid<NeoFeed>>
        = flow {
            try {
                val listAsteroid = asteroidRepository.getAsteroids(startDate, endDate)
                val favoriteAsteroid = asteroidRepository.getSavedAsteroids()
                when(typeList){
                    TypeList.MainList -> emit(ResultAsteroid.Success(listAsteroid))
                    TypeList.DangerousList -> emit(ResultAsteroid.Success(NeoFeed(listAsteroid.elementCount,
                        listAsteroid.asteroidsByDate.filter {
                            it.isPotentiallyHazardousAsteroid!!})))
                    TypeList.FavoriteList-> emit(ResultAsteroid.Success(favoriteAsteroid))
                }
            } catch (throwable: Exception) {
                emit(ResultAsteroid.Error(throwable))
            }
    }.flowOn(Dispatchers.IO)




}