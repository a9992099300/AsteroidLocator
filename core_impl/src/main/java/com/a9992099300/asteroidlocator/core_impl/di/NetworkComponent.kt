package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.network.NetworkProvider
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
internal interface NetworkComponent: NetworkProvider {

    fun provideAsteroidApi(): AsteroidService

    companion object {
        private var networkComponent: NetworkComponent? = null

        fun create(): NetworkComponent {
            return networkComponent
                ?: DaggerNetworkComponent.create().also { networkComponent = it }
        }
    }
}