package com.a9992099300.asteroidlocator.core_impl.db

interface DatabaseProvider {
    fun provideAsteroidsDao(): AsteroidsDao
}