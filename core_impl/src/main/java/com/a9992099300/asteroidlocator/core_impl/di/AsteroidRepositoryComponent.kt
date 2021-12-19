package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.NetworkProvider
import com.a9992099300.asteroidlocator.core_api.di.RepositoryProvider
import dagger.Component
import javax.inject.Scope

@RepoScope
@Component(
    modules = [AsteroidRepositoryModule::class],
    dependencies = [NetworkComponent::class ]
)
interface AsteroidRepositoryComponent: RepositoryProvider {}

@Scope
annotation class RepoScope