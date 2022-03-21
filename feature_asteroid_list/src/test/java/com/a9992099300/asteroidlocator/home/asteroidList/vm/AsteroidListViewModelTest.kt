package com.a9992099300.asteroidlocator.home.asteroidList.vm

import androidx.lifecycle.viewModelScope
import app.cash.turbine.test
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.home.ProviderFactory
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.TypeList
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
import com.a9992099300.asteroidsneo.data.NeoFeed
import com.a9992099300.asteroidsneo.data.NeoFeedUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.time.ExperimentalTime

class AsteroidListViewModelTest {

    private val  uIMapper: ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeedUI>> = mock()
    private val loadAsteroidsUseCase: LoadAsteroidsUseCase = mock()
    private val nearEarthObjectMapper: ModelMapper<NearEarthObject, NearEarthObjectUI> = mock()
    private val saveDeleteAsteroidsUseCase: SaveDeleteAsteroidsUseCase  = mock()
    private val testDispatcher = TestCoroutineDispatcher()

    private val asteroidListViewModel =
        AsteroidListViewModel(
            uIMapper,
            loadAsteroidsUseCase,
            nearEarthObjectMapper,
            saveDeleteAsteroidsUseCase,
            testDispatcher
        )

    @ExperimentalCoroutinesApi
    @Before
    fun before() {
        Dispatchers.setMain(testDispatcher)
    }

    @ExperimentalTime
    @Test
    fun `should emit Success with non empty expenses list`() {
        runBlocking {
            val expected = ProviderFactory.getAsteroidsUi()

            whenever(loadAsteroidsUseCase("startDate", "endDate", TypeList.MainList)).thenReturn(
                flow{ResultAsteroid.Success(ProviderFactory.getAsteroids())})
            whenever(uIMapper.mapToExternalLayer(any())).thenReturn(
                UIState.ShowContent(expected))

            asteroidListViewModel.loadAsteroids("startDate", "endDate", TypeList.MainList)

                assertEquals(UIState.ShowContent(expected), asteroidListViewModel.asteroidFlow.value )
            asteroidListViewModel.asteroidFlow.test {
                Assert.assertEquals(UIState.ShowContent(expected), expectItem())

            }

//            val actual =asteroidListViewModel.asteroidFlow.value
//            Assert.assertEquals(UIState.ShowContent(expected), actual)


         }
    }

    @After
    fun after() {
        Dispatchers.resetMain()
    }
}