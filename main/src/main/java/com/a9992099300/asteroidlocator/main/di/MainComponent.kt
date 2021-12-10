package com.a9992099300.asteroidlocator.main.di

import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
import com.a9992099300.asteroidlocator.main.MainActivity
import dagger.Component

@Component(
    dependencies = [ProvidersFacade::class]
)
interface MainComponent {
    companion object {

        fun create(providersFacade: ProvidersFacade): MainComponent {
            return DaggerMainComponent.builder().providersFacade(providersFacade).build()
        }
   }

    fun inject(mainActivity: MainActivity)
}