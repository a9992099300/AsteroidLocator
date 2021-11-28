package com.a9992099300.asteroidlocator.core_impl.di

import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class  Core

@Core
@Component
(dependencies = [NetworkComponent::class])
interface AsteroidRepositoryComponent {

    companion object {
        private var asteroidRepositoryComponent: AsteroidRepositoryComponent? = null

        fun create(): AsteroidRepositoryComponent{
            return asteroidRepositoryComponent
                ?: DaggerAsteroidRepositoryComponent.builder()
                    .networkComponent(NetworkComponent.create())
                    .build()
                    .also { asteroidRepositoryComponent = it }
        }
    }
}