package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_impl.db.AsteroidsDao
import com.a9992099300.asteroidlocator.core_impl.db.DatabaseProvider
import com.a9992099300.asteroidlocator.core_impl.di.DaggerNetworkComponent
import com.a9992099300.asteroidlocator.core_impl.di.DtoMappersComponent
import com.a9992099300.asteroidlocator.core_impl.di.NetworkComponent
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@DatabaseScope
@Component(modules = [DatabaseModule::class],
    dependencies = [ContextProvider::class,
  //  DtoMappersComponent::class
    ])
interface DatabaseComponent: DatabaseProvider{

    companion object {
        private var databaseComponent: DatabaseComponent? = null

        fun create(contextProvider: ContextProvider): DatabaseComponent {
            return databaseComponent
                ?: DaggerDatabaseComponent.builder()
                   // .dtoMappersComponent(DtoMappersComponent.create())
                    .contextProvider(contextProvider)
                    .build()
                    .also { databaseComponent = it }
        }
    }
}

@Scope
annotation class DatabaseScope

