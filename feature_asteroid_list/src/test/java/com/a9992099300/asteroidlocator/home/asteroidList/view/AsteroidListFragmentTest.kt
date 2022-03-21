package com.a9992099300.asteroidlocator.home.asteroidList.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.home.asteroidList.vm.AsteroidListViewModel
import com.a9992099300.asteroidlocator.home.asteroidList.vm.AsteroidListViewModelFactory
import com.a9992099300.asteroidsneo.data.NeoFeedUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast
import java.lang.RuntimeException


@RunWith(AndroidJUnit4::class)
class AsteroidListFragmentTest{

    private val asteroidListViewModel: AsteroidListViewModel = mock()


  @Config(manifest = "app/src/main/AndroidManifest.xml")
    @Test
    fun `should show  message Error when Error emited`() {
        runBlocking {
            //given:
            val flow = MutableStateFlow<UIState<NeoFeedUI>>(UIState.ShowLoading)
            whenever(asteroidListViewModel.asteroidFlow).thenReturn(flow)

            val factoryMock = mock<AsteroidListViewModelFactory>()
            whenever(factoryMock.create<AsteroidListViewModel>(any())).thenReturn(asteroidListViewModel)

            val fragmentScenario =
                launchFragmentInContainer<AsteroidListFragment>(initialState = Lifecycle.State.CREATED)
            fragmentScenario.onFragment { fragment ->
                fragment.viewModelFactory = factoryMock
                fragmentScenario.moveToState(Lifecycle.State.STARTED)
            }

            //when:
            flow.emit(UIState.ShowError(RuntimeException("Some Error")))

            //then:
            assertEquals("Error message: Some Error", ShadowToast.getTextOfLatestToast())
        }
    }

}