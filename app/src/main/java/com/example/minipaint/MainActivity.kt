package com.example.minipaint

import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting my canvas view as default view for mainactivity
        val myCanvasView=MyCanvasView(this)
        myCanvasView.systemUiVisibility= SYSTEM_UI_FLAG_FULLSCREEN
        myCanvasView.contentDescription=getString(R.string.canvasContentDescription)
        setContentView(myCanvasView)
    }
}