package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.scope.UnderRepoScope
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidApi
import dagger.Component
import javax.inject.Scope

@UnderRepoScope
@Component(dependencies = [ContextProvider::class],
    modules = [NetworkModule::class])
internal interface NetworkComponent {

    fun provideNetworkApi(): AsteroidApi

    companion object {
        private var networkComponent: NetworkComponent? = null

        fun create(contextProvider: ContextProvider): NetworkComponent {
            return networkComponent
                ?: DaggerNetworkComponent.builder()
                    .contextProvider(contextProvider)
                    .build()
                    .also { networkComponent = it }
        }
    }
}


