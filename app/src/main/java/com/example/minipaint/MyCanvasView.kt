package com.example.minipaint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
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
}