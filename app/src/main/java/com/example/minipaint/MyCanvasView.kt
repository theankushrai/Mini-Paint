package com.example.minipaint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import androidx.core.content.res.ResourcesCompat

private const val STROKE_WIDTH = 12f

class MyCanvasView(context: Context): View(context) {

    private lateinit var extraBitmap: Bitmap
    private lateinit var extraCanvas:Canvas

    private val backgroundColor =ResourcesCompat.getColor(resources,R.color.colorBackground,null)
    private val drawColor =ResourcesCompat.getColor(resources,R.color.colorPaint,null)

    // Set up the paint with which to draw.
    private val paint = Paint().apply {
        color = drawColor
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }

    //path drawn by the user
    private var path= Path()

    private var motionTouchEventX=0f
    private var motionTouchEventY=0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // removing old extra bitmap and canvas instances before creating new ones
        if(::extraBitmap.isInitialized) extraBitmap.recycle()
        //bitmap and canvas are created every time user changes the canvas
        extraBitmap= Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        extraCanvas=Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(extraBitmap,0f,0f,null)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y

        when(event?.action){
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }

    private fun touchUp() {
        TODO("Not yet implemented")
    }

    private fun touchMove() {
        TODO("Not yet implemented")
    }

    private fun touchStart() {
        TODO("Not yet implemented")
    }


}