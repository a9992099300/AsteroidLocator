package com.a9992099300.asteroidlocator.home.di

import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
import com.a9992099300.asteroidlocator.home.asteroidList.AsteroidListFragment
import dagger.Component

@FragmentScope
@Component(modules = [AsteroidListModule::class], dependencies = [ProvidersFacade::class])
internal interface AsteroidListComponent {

    fun inject(asteroidListFragment: AsteroidListFragment)

}