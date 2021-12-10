package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.MapperProvider
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.NeoEstimatedDiameterDto
import com.a9992099300.asteroidsneo.data.NeoEstimatedDiameter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DtoMappersModule::class])
interface DtoMappersComponent : MapperProvider
