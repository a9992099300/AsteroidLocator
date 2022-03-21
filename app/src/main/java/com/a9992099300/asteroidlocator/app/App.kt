package com.a9992099300.asteroidlocator.app

import android.app.Application
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
// import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
import com.a9992099300.asteroidlocator.di.FacadeComponent

open class App : Application(), AppWithFacade {

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }

    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }
}