package com.a9992099300.asteroidlocator.di

import android.app.Application
import com.a9992099300.asteroidlocator.app.App
import com.a9992099300.asteroidlocator.core.CoreProviderFactory
//import com.a9992099300.asteroidlocator.core.CoreProviderFactory
import com.a9992099300.asteroidlocator.core_api.di.*
import dagger.Component


@Component(
    dependencies = [
        ContextProvider::class,
        UIMapperProvider::class,
        RepositoryProvider::class
    ]
)
internal interface FacadeComponent : ProvidersFacade
{

    companion object {
        private var facadeComponent: FacadeComponent? = null

        fun init(application: Application): FacadeComponent {
            val contextProvider = ContextComponent.create(application)
            val uiMapperProvider = CoreProviderFactory.createMapperBuilder()

            return facadeComponent ?:
            DaggerFacadeComponent.builder()
                .contextProvider(contextProvider)
                .uIMapperProvider(uiMapperProvider)
                .repositoryProvider(CoreProviderFactory.createRepositoryBuilder(contextProvider))
                .build()
                .also { facadeComponent = it }
            }
        }
    fun inject(app: App)
}

