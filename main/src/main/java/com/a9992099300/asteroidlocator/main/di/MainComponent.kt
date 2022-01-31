package com.a9992099300.asteroidlocator.main.di

import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
import com.a9992099300.asteroidlocator.main.MainActivity
import com.a9992099300.asteroidlocator.main_navigation.di.NavigatorComponent
import dagger.Component

@Component(modules = [MainActivityModule::class],
    dependencies = [ProvidersFacade::class
        ,NavigatorComponent::class ]
)
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}