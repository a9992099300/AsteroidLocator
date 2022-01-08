package com.a9992099300.asteroidlocator.home.asteroidList.usecase

sealed class TypeList{
    object MainList : TypeList()
    object DangerousList : TypeList()
    object FavoriteList : TypeList()
}


