package com.a9992099300.asteroidlocator.core_impl.di


import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.NavigationProvider
import dagger.Component

@Component(modules = [NavigationModule::class],
    dependencies = [ContextProvider::class])
internal interface NavigationComponent: NavigationProvider {

    companion object {
        private var navigationComponent: NavigationComponent? = null

        fun create(contextProvider: ContextProvider): NavigationComponent {
            return navigationComponent
                ?: DaggerNavigationComponent.builder()
                    .contextProvider(contextProvider)
                    .build()
                    .also { navigationComponent = it }
        }
    }
}