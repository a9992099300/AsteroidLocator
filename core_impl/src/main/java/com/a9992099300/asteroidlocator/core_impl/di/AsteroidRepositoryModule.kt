package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.domain.usecases.AsteroidRepository
import com.a9992099300.asteroidlocator.core_impl.adapter.AsteroidNetworkSource
import com.a9992099300.asteroidlocator.core_impl.adapter.AsteroidRepositoryImpl
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidNetworkSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable


@Module
internal interface AsteroidRepositoryModule {

    @Binds
    fun bindAsteroidRepository(asteroidRepositoryImpl: AsteroidRepositoryImpl): AsteroidRepository

}


