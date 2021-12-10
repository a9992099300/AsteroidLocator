package com.a9992099300.asteroidlocator.di

import android.app.Application
import com.a9992099300.asteroidlocator.core.CoreProviderFactory
import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.MapperProvider
import com.a9992099300.asteroidlocator.core_api.di.NetworkProvider
import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
import dagger.Component


@Component(
    dependencies = [
        ContextProvider::class,
        NetworkProvider::class,
        MapperProvider::class
    ]
)
internal interface FacadeComponent : ProvidersFacade {

    companion object {
        private var facadeComponent: FacadeComponent? = null

        fun init(application: Application): FacadeComponent {
            val contextProvider = ContextComponent.create(application)
            return facadeComponent ?:
            DaggerFacadeComponent.builder()
                .contextProvider(contextProvider)
                .networkProvider(CoreProviderFactory.createNetworkBuilder(contextProvider))
                .mapperProvider(CoreProviderFactory.createMapperBuilder())
                .build()
                .also { facadeComponent = it }
            }
        }
    fun inject(app: App)
}

