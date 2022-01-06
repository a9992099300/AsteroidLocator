package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.UIMapperProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIMappersModule::class])
interface UIMappersComponent : UIMapperProvider
