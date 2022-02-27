package com.a9992099300.domain_asteroid.usecase

import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidRepository
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCaseImpl
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.TypeList
import com.a9992099300.asteroidsneo.data.NeoFeed
import com.a9992099300.domain_asteroid.ProviderFactory
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class LoadAsteroidsUseCaseImplTest {

    private val asteroidRepository: AsteroidRepository = mock()

    private val loadAsteroidsUseCaseImpl =
        LoadAsteroidsUseCaseImpl(
            asteroidRepository
        )

    @Test
     fun `should emit Success with Main List`() {
        runBlocking {
            whenever(asteroidRepository.getAsteroids(any(), any())).thenReturn(
                ProviderFactory.getAsteroids()
            )
            whenever(asteroidRepository.getSavedAsteroids()).thenReturn(
                ProviderFactory.getSavedAsteroids()
            )

            val actual = loadAsteroidsUseCaseImpl.invoke("startDate", "endDate", TypeList.MainList)

            assertEquals(listOf(ResultAsteroid.Success(ProviderFactory.getAsteroids())), actual.toList())
        }
    }


    @Test
    fun `should emit Success with Favorite List`() {
        runBlocking {
            whenever(asteroidRepository.getAsteroids(any(), any())).thenReturn(
                ProviderFactory.getAsteroids()
            )
            whenever(asteroidRepository.getSavedAsteroids()).thenReturn(
                ProviderFactory.getSavedAsteroids()
            )

            val actual = loadAsteroidsUseCaseImpl.invoke("startDate", "endDate", TypeList.FavoriteList)

            assertEquals(listOf(ResultAsteroid.Success(ProviderFactory.getSavedAsteroids())), actual.toList())
        }
    }

    @Test
    fun `should emit Success with Dangerous List`() {
        runBlocking {
            whenever(asteroidRepository.getAsteroids(any(), any())).thenReturn(
                ProviderFactory.getAsteroids()
            )
            whenever(asteroidRepository.getSavedAsteroids()).thenReturn(
                ProviderFactory.getSavedAsteroids()
            )

            val actual = loadAsteroidsUseCaseImpl.invoke("startDate", "endDate", TypeList.DangerousList)

            assertEquals(listOf(ResultAsteroid.Success(ProviderFactory.getDangerousAsteroids())), actual.toList())
        }
    }

    @Test
    fun `should emit Empty List`() {
        runBlocking {
            whenever(asteroidRepository.getAsteroids(any(), any())).thenReturn(
                NeoFeed(elementCount = 0, asteroidsByDate = emptyList())
            )
            whenever(asteroidRepository.getSavedAsteroids()).thenReturn(
                NeoFeed(elementCount = 0, asteroidsByDate = emptyList())
            )

            val actual = loadAsteroidsUseCaseImpl.invoke("startDate", "endDate", TypeList.MainList)

            assertEquals(listOf(ResultAsteroid.Empty), actual.toList())
        }
    }

    @Test
    fun `should emit Error `() {
        runBlocking {
            val expectedException = RuntimeException("Error")
            whenever(asteroidRepository.getAsteroids(any(), any())).thenThrow(
                expectedException
            )
            whenever(asteroidRepository.getSavedAsteroids()).thenReturn(
                ProviderFactory.getSavedAsteroids()
            )

            val actual = loadAsteroidsUseCaseImpl.invoke("startDate", "endDate", TypeList.MainList)

            assertEquals(listOf(ResultAsteroid.Error(expectedException)), actual.toList())
        }
    }
}