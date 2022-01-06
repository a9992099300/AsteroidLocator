package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.data.AsteroidRepository
import com.a9992099300.asteroidlocator.core_api.network.AsteroidNetworkSource
import com.a9992099300.asteroidlocator.core_impl.db.AsteroidLocalSource
import com.a9992099300.asteroidlocator.core_impl.db.AsteroidLocalSourceImpl
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidNetworkSourceImpl
import com.a9992099300.asteroidlocator.core_impl.repository.AsteroidRepositoryImpl
import dagger.Binds
import dagger.Module


@Module
internal interface AsteroidRepositoryModule {

    @Binds
    fun bindAsteroidRepository(asteroidRepositoryImpl: AsteroidRepositoryImpl): AsteroidRepository

    @Binds
    fun bindAsteroidsLocalSource(asteroidsLocalSourceImpl: AsteroidLocalSourceImpl): AsteroidLocalSource

}


