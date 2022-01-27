package com.a9992099300.asteroidlocator.main.di

import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
import com.a9992099300.asteroidlocator.main.MainActivity
import dagger.Component

@Component(modules = [MainActivityModule::class],
    dependencies = [ProvidersFacade::class]
)
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}