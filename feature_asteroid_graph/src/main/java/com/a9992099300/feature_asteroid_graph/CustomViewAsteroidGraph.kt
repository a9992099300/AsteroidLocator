package com.a9992099300.feature_asteroid_graph

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NeoCloseApproachData


class CustomViewAsteroidGraph(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {

    private val defaultWidth = resources.getDimension(R.dimen.custom_view_graph).toInt()
    private val defaultHeight = resources.getDimension(R.dimen.custom_view_graph).toInt()
    private var rectF = RectF()
    private val userPaint = UserPaint()

    private var stateView = listOf(NearEarthObject("id","name"," ",100.0,110.0,true,
        listOf(NeoCloseApproachData("id","date", 111L, 10.0, 4.0, 4.0)),true," ",))

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)

        when {
            widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST -> {
                widthSize = defaultWidth
                heightSize = defaultHeight
                setMeasuredDimension(widthSize, heightSize)
            }

            widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.AT_MOST -> {
                setMeasuredDimension(widthSize, widthSize)
            }
            widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.EXACTLY -> {
                setMeasuredDimension(heightSize, heightSize)
            }

            widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY && widthSize
                    != heightSize -> {
                if (widthSize >= heightSize) setMeasuredDimension(heightSize, heightSize)
                else setMeasuredDimension(widthSize, widthSize)
            }
            (widthMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.AT_MOST) && heightMode
                    == MeasureSpec.UNSPECIFIED -> {
                setMeasuredDimension(widthSize, widthSize)
            }
            else ->
                if (widthSize >= heightMode) {
                    setMeasuredDimension(heightSize, heightSize)
                } else {
                    setMeasuredDimension(widthSize, widthSize)
                }
        }

        rectF.set(
            width.toFloat() * 0.1f, height.toFloat() * 0.1f,
            width.toFloat() * 0.9f, height.toFloat() * 0.9f
        )

    }

    override fun onDraw(canvas: Canvas) {
        if (stateView.isEmpty()) return
        var arc = 0f
        var arcItem = 360/stateView.size

        stateView.forEachIndexed{ i, item ->
            val path = Path()
            path.reset()
            path.arcTo(rectF, arcItem.toFloat(), arcItem + 1F)
           // path.addCircle(rectF,Path.Direction.CW)
            canvas.drawPath(path, userPaint.blackPaint.apply {
                isAntiAlias = true
            })

        }

    }
    }