package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.MapperProvider
import com.a9992099300.asteroidlocator.core_api.di.NetworkProvider
import com.a9992099300.asteroidlocator.core_impl.adapter.AsteroidNetworkSource
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [ContextProvider::class, MapperProvider::class],
    modules = [NetworkModule::class])
interface NetworkComponent: NetworkProvider {

    fun provideNetworkApi(): AsteroidService
    fun provideAsteroidNetworkSource(): AsteroidNetworkSource
}