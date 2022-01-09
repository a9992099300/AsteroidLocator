package com.a9992099300.asteroidlocator.home.asteroidList.adapter

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView

internal class TypeDecoration: RecyclerView.ItemDecoration() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style =Paint.Style.STROKE
    }

//    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
//
//       c.drawRect(0f,0f, 100f, 100f, paint)
//    }
}