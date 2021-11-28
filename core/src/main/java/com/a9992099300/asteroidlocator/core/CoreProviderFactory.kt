package com.a9992099300.asteroidlocator.core


import com.a9992099300.asteroidlocator.core_impl.di.AsteroidRepositoryComponent

object CoreProviderFactory {
    fun createAsteroidRepositoryComponent(): AsteroidRepositoryComponent {
        return AsteroidRepositoryComponent.create()
    }
}