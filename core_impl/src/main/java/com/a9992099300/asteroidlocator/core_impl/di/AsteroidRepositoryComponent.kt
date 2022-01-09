package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.RepositoryProvider
import com.a9992099300.asteroidlocator.core_api.di.scope.FacadeScope
import com.a9992099300.asteroidlocator.core_api.network.AsteroidNetworkSource
import dagger.Component
import javax.inject.Scope

@FacadeScope
@Component(
    modules = [AsteroidRepositoryModule::class],
    dependencies = [NetworkComponent::class,
        DatabaseComponent::class,
        DtoMappersComponent::class]
)
interface AsteroidRepositoryComponent : RepositoryProvider {

    fun provideAsteroidNetworkSource(): AsteroidNetworkSource

    companion object {
        private var asteroidRepositoryComponent: AsteroidRepositoryComponent? = null

        fun create(contextProvider: ContextProvider): AsteroidRepositoryComponent {
            return asteroidRepositoryComponent
                ?: DaggerAsteroidRepositoryComponent.builder()
                    .databaseComponent(DatabaseComponent.create(contextProvider))
                    .networkComponent(NetworkComponent.create(contextProvider))
                    .dtoMappersComponent(DtoMappersComponent.create())
                    .build()
                    .also { asteroidRepositoryComponent = it }
        }
    }
}
