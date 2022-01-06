package com.a9992099300.asteroidlocator.core_api.domain.entities

sealed class TypeList{
    object MainList : TypeList()
    object DangerousList : TypeList()
    object FavoriteList : TypeList()
}


