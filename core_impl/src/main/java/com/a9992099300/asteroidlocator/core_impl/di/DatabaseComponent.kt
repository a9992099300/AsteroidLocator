package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.scope.UnderRepoScope
import com.a9992099300.asteroidlocator.core_impl.db.DatabaseProvider
import dagger.Component

@UnderRepoScope
@Component(modules = [DatabaseModule::class],
    dependencies = [ContextProvider::class])
internal interface DatabaseComponent: DatabaseProvider{

    companion object {
        private var databaseComponent: DatabaseComponent? = null

        fun create(contextProvider: ContextProvider): DatabaseComponent {
            return databaseComponent
                ?: DaggerDatabaseComponent.builder()
                    .contextProvider(contextProvider)
                    .build()
                    .also { databaseComponent = it }
        }
    }
}



