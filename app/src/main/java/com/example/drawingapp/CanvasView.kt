package com.example.drawingapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class canvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    //Define local variables
    private var bitmap: Bitmap? = null
    private var mainCanvas: Canvas? = null
    private var paintCanvas: Canvas? = null

    //Initialize the canvas
    init {
        bitmap = Bitmap.createBitmap(1024, 1024, Bitmap.Config.ARGB_8888) //Should be taken from database in the future
        mainCanvas = Canvas() //Should be stored in a class that has a longer lifecycle in the future
        paintCanvas = Canvas(bitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //Draw the bitmap
        bitmap?.let { canvas.drawBitmap(it, 0f, 0f, null) }
    }

    //Function to draw on the canvas
    fun drawOnCanvas(x: Float, y: Float, size: Float, brush: Paint) {
        paintCanvas?.drawCircle(x, y, size, brush)

        //Reset the canvas
        invalidate()
    }
}