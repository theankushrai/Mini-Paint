package com.example.minipaint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import androidx.core.content.res.ResourcesCompat

class MyCanvasView(context: Context): View(context) {

    private lateinit var extraBitmap: Bitmap
    private lateinit var extraCanvas:Canvas

    private val backgroundColor =ResourcesCompat.getColor(resources,R.color.colorBackground,null)

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