package com.a9992099300.asteroidlocator.core_impl.db.typeconverter

interface AbstractTypeConverter<R, S> {

    fun save(restored: R): S

    fun restore(saved: S): R
}