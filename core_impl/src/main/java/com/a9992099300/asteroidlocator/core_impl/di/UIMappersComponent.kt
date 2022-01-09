package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.UIMapperProvider
import com.a9992099300.asteroidlocator.core_api.di.scope.FacadeScope
import dagger.Component

@FacadeScope
@Component(modules = [UIMappersModule::class])
interface UIMappersComponent : UIMapperProvider
