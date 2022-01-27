package com.a9992099300.asteroidlocator.core


import com.a9992099300.asteroidlocator.core_api.di.RepositoryProvider
import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.SharedPreferenceProvider
import com.a9992099300.asteroidlocator.core_api.di.UIMapperProvider
import com.a9992099300.asteroidlocator.core_impl.di.*

object CoreProviderFactory {


    fun createMapperBuilder(): UIMapperProvider {
        return DaggerUIMappersComponent.create()
    }

    fun createSharedPreferenceBuilder(contextProvider: ContextProvider): SharedPreferenceProvider {
        return DaggerSharedPreferencesComponent.builder().contextProvider(contextProvider).build()
    }

    fun createRepositoryBuilder(contextProvider: ContextProvider)
    : RepositoryProvider {
        return AsteroidRepositoryComponent.create(contextProvider)
    }

}