package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.network.AsteroidNetworkSource
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidApi
import dagger.Component
import javax.inject.Scope

@NetworkScope
@Component(dependencies = [ContextProvider::class,
       DtoMappersComponent::class],
    modules = [NetworkModule::class])
interface NetworkComponent {

    fun provideNetworkApi(): AsteroidApi
    fun provideAsteroidNetworkSource(): AsteroidNetworkSource

    companion object {
        private var networkComponent: NetworkComponent? = null

        fun create(contextProvider: ContextProvider): NetworkComponent {
            return networkComponent
                ?: DaggerNetworkComponent.builder()
                    .dtoMappersComponent(DtoMappersComponent.create())
                    .contextProvider(contextProvider)
                    .build()
                    .also { networkComponent = it }
        }
    }
}

@Scope
annotation class NetworkScope

