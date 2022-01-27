package com.a9992099300.asteroidlocator.di

import android.app.Application
import com.a9992099300.asteroidlocator.app.App
import com.a9992099300.asteroidlocator.core.CoreProviderFactory
//import com.a9992099300.asteroidlocator.core.CoreProviderFactory
import com.a9992099300.asteroidlocator.core_api.di.*
import com.a9992099300.asteroidlocator.core_api.di.scope.FacadeScope
import dagger.Component
import javax.inject.Scope

@FacadeScope
@Component(
    dependencies = [
        ContextProvider::class,
        UIMapperProvider::class,
        RepositoryProvider::class,
        SharedPreferenceProvider::class,
    ]
)
internal interface FacadeComponent : ProvidersFacade
{

    companion object {
        private var facadeComponent: FacadeComponent? = null

        fun init(application: Application): FacadeComponent {
            val contextProvider = ContextComponent.create(application)
            val uiMapperProvider = CoreProviderFactory.createMapperBuilder()
            val sharedPreferenceProvider = CoreProviderFactory.createSharedPreferenceBuilder(contextProvider)

            return facadeComponent ?:
            DaggerFacadeComponent.builder()
                .contextProvider(contextProvider)
                .uIMapperProvider(uiMapperProvider)
                .repositoryProvider(CoreProviderFactory.createRepositoryBuilder(contextProvider))
                .sharedPreferenceProvider(sharedPreferenceProvider)
                .build()
                .also { facadeComponent = it }
            }
        }
    fun inject(app: App)
}



