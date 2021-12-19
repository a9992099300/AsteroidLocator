package com.a9992099300.asteroidlocator.di

import android.app.Application
import com.a9992099300.asteroidlocator.app.App
import com.a9992099300.asteroidlocator.core.CoreProviderFactory
import com.a9992099300.asteroidlocator.core_api.di.*
import dagger.Component


@Component(
    dependencies = [
        ContextProvider::class,
        NetworkProvider::class,
        MapperProvider::class,
        RepositoryProvider::class
    ]
)
internal interface FacadeComponent : ProvidersFacade {

    companion object {
        private var facadeComponent: FacadeComponent? = null

        fun init(application: Application): FacadeComponent {
            val contextProvider = ContextComponent.create(application)
            val mapperProvider = CoreProviderFactory.createMapperBuilder()
            val networkProvider = CoreProviderFactory.createNetworkBuilder(contextProvider, mapperProvider)

            return facadeComponent ?:
            DaggerFacadeComponent.builder()
                .contextProvider(contextProvider)
                .mapperProvider(mapperProvider)
                .networkProvider(networkProvider)
                .repositoryProvider(CoreProviderFactory.createRepositoryBuilder(networkProvider))
                .build()
                .also { facadeComponent = it }
            }
        }
    fun inject(app: App)
}

