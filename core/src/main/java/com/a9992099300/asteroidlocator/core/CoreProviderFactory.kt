package com.a9992099300.asteroidlocator.core


import com.a9992099300.asteroidlocator.core_api.di.RepositoryProvider
import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.MapperProvider
import com.a9992099300.asteroidlocator.core_api.di.NetworkProvider
import com.a9992099300.asteroidlocator.core_impl.di.DaggerAsteroidRepositoryComponent
import com.a9992099300.asteroidlocator.core_impl.di.DaggerDtoMappersComponent
import com.a9992099300.asteroidlocator.core_impl.di.DaggerNetworkComponent
import com.a9992099300.asteroidlocator.core_impl.di.NetworkComponent

object CoreProviderFactory {
        fun createNetworkBuilder(contextProvider: ContextProvider, mapperProvider: MapperProvider): NetworkProvider {
            return DaggerNetworkComponent.builder()
                .contextProvider(contextProvider)
                .mapperProvider(mapperProvider)
                .build()
    }

    fun createMapperBuilder(): MapperProvider {
        return DaggerDtoMappersComponent.create()
    }

    fun createRepositoryBuilder(networkProvider: NetworkProvider): RepositoryProvider {
        return DaggerAsteroidRepositoryComponent.builder()
            .networkComponent(networkProvider as NetworkComponent?)
            .build()
    }

}