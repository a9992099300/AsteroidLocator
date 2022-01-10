package com.a9992099300.asteroidlocator.home.asteroidList.usecase

import com.a9992099300.asteroidlocator.core_api.data.AsteroidRepository
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.home.Ext.containsId
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@Reusable
internal class LoadAsteroidsUseCaseImpl @Inject constructor(
    private val asteroidRepository: AsteroidRepository,
): LoadAsteroidsUseCase {

    override operator fun invoke(
        startDate: String,
        endDate: String,
        typeList: TypeList
    ): Flow<ResultAsteroid<NeoFeed>>
        = flow {
            try {
                val listAsteroids = asteroidRepository.getAsteroids(startDate, endDate)
                val favoriteAsteroids = asteroidRepository.getSavedAsteroids()
                val dangerousAsteroids = listAsteroids.asteroidsByDate.filter {
                    it.isPotentiallyHazardousAsteroid == true
                }

                for (i in listAsteroids.asteroidsByDate)
                    i.isFavorite = i.id?.let { favoriteAsteroids.asteroidsByDate.containsId(it) } == true


                when(typeList){
                    TypeList.MainList ->
                        if (listAsteroids.asteroidsByDate.isNotEmpty())
                        emit(ResultAsteroid.Success(listAsteroids))
                        else emit(ResultAsteroid.Empty)
                    TypeList.DangerousList ->
                        if (dangerousAsteroids.isNotEmpty())
                        emit(ResultAsteroid.Success(NeoFeed(listAsteroids.elementCount,dangerousAsteroids)))
                        else emit(ResultAsteroid.Empty)
                    TypeList.FavoriteList ->
                        if (favoriteAsteroids.asteroidsByDate.isNotEmpty())
                        emit(ResultAsteroid.Success(favoriteAsteroids))
                        else emit(ResultAsteroid.Empty)
                }
            } catch (throwable: Exception) {
                emit(ResultAsteroid.Error(throwable))
            }
    }.flowOn(Dispatchers.IO)

}