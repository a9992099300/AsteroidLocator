package com.a9992099300.asteroidlocator.core


import com.a9992099300.asteroidlocator.core_api.di.RepositoryProvider
import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.UIMapperProvider
import com.a9992099300.asteroidlocator.core_impl.di.*

object CoreProviderFactory {


    fun createMapperBuilder(): UIMapperProvider {
        return DaggerUIMappersComponent.create()
    }

    fun createRepositoryBuilder(contextProvider: ContextProvider)
    : RepositoryProvider {
        return AsteroidRepositoryComponent.create(contextProvider)
    }

}