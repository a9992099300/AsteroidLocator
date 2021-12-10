package com.a9992099300.asteroidlocator.di

import android.content.Context
import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
internal interface ContextComponent : ContextProvider {

    companion object {
        private var contextComponent: ContextComponent? = null

        fun create(context: Context): ContextComponent {
            return contextComponent
                ?: DaggerContextComponent
                    .builder()
                    .context(context.applicationContext)
                    .build()
                    .also { contextComponent = it }
        }
    }

//    @Component.Factory
//    interface Factory {
//        fun create(@BindsInstance context: Context): ContextComponent
//    }

    @Component.Builder // переделать на factory
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder
        fun build(): ContextComponent
    }
}
