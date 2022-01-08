package com.a9992099300.asteroidlocator.home.Ext

import com.a9992099300.asteroidsneo.data.NearEarthObject



fun  List<NearEarthObject>.containsId(string: String): Boolean{
   var contain = false
    forEach {
        if (it.id == string)
           contain = true
    }
    return contain
}


