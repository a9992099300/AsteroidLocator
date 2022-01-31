package com.a9992099300.asteroidlocator.core


import com.a9992099300.asteroidlocator.core_api.di.*
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

    fun createNavigation(contextProvider: ContextProvider)
            : NavigationProvider {
        return DaggerNavigationComponent.builder().contextProvider(contextProvider).build()
    }

}