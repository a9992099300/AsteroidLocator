package com.a9992099300.asteroidlocator.main_navigation.di


import androidx.navigation.NavController
import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.NavigationProvider
import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
import com.a9992099300.asteroidlocator.main_navigation.Navigator
import dagger.Component

@Component(modules = [NavigatorModule::class], dependencies = [ProvidersFacade::class] )
interface NavigatorComponent {
    fun provideNavigator(): Navigator

    companion object {
        private var navigationComponent: NavigatorComponent? = null


        fun create(providersFacade: ProvidersFacade): NavigatorComponent {
            return navigationComponent
                ?: DaggerNavigatorComponent.builder()
                    .providersFacade(providersFacade)
                    .build()
                    .also { navigationComponent = it }
        }
    }
}