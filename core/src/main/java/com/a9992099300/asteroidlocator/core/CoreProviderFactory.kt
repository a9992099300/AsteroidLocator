package com.a9992099300.asteroidlocator.core


import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.MapperProvider
import com.a9992099300.asteroidlocator.core_api.di.NetworkProvider
import com.a9992099300.asteroidlocator.core_impl.di.DaggerDtoMappersComponent
import com.a9992099300.asteroidlocator.core_impl.di.DaggerNetworkComponent

object CoreProviderFactory {
        fun createNetworkBuilder(contextProvider: ContextProvider): NetworkProvider {
            return DaggerNetworkComponent.builder().contextProvider(contextProvider).build()
    }

    fun createMapperBuilder(): MapperProvider {
        return DaggerDtoMappersComponent.create()
    }

}