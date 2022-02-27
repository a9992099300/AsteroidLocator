package com.a9992099300.domain_asteroid.usecase

import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidRepository
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCaseImpl
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCaseImpl
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.TypeList
import com.a9992099300.domain_asteroid.ProviderFactory
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.mockito.kotlin.*

class SaveDeleteAsteroidsUseCaseImplTest{

    private val asteroidRepository: AsteroidRepository = mock()

    private val saveDeleteAsteroidsUseCaseImpl =
        SaveDeleteAsteroidsUseCaseImpl(
            asteroidRepository
        )

    @Test
    fun `should delete asteroid`() {
        runBlocking {

            saveDeleteAsteroidsUseCaseImpl.invoke(ProviderFactory.getAsteroids().asteroidsByDate[0])

            verify(asteroidRepository, times(1)).deleteAsteroid(ProviderFactory.getAsteroids().asteroidsByDate[0].id)
        }
    }

    @Test
    fun `should save asteroid`() {
        runBlocking {

            saveDeleteAsteroidsUseCaseImpl.invoke(ProviderFactory.getAsteroids().asteroidsByDate[1])

            verify(asteroidRepository, times(1)).saveAsteroid(ProviderFactory.getAsteroids().asteroidsByDate[1])
        }
    }
}