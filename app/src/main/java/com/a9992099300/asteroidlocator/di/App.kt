package com.a9992099300.asteroidlocator.di

import android.app.Application
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade

class App : Application(), AppWithFacade {

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }

    override fun getFacade(): ProvidersFacade {
        return FacadeComponent.init(this)
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }
}