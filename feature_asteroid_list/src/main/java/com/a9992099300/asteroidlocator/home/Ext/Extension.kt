package com.a9992099300.asteroidlocator.home.Ext

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import com.a9992099300.asteroidsneo.data.NearEarthObject


fun List<NearEarthObject>.containsId(string: String): Boolean {
    var contain = false
    forEach {
        if (it.id == string)
            contain = true
    }
    return contain
}

private fun String?.isValid() = this != null && isNotBlank()

val Number.toPx
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}



