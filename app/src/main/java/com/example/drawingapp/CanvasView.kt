package com.example.drawingapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    //Define local variables
    var bitmap: Bitmap? = null
    var mainCanvas: Canvas? = null
    var paintCanvas: Canvas? = null
    var brush: Paint = Paint()

    //Tool properties
    var toolSize: Float = 5f
    var toolColor: Int = 0
    var toolShape: String = "PEN"

    //Position properties
    var lastX: Float = 0f
    var lastY: Float = 0f

    //Initialize the canvas
    init {
        bitmap = Bitmap.createBitmap(1024, 1024, Bitmap.Config.ARGB_8888) //Should be taken from database in the future
        mainCanvas = Canvas() //Should be stored in a class that has a longer lifecycle in the future
        paintCanvas = Canvas(bitmap!!)

        //Draw border around the canvas
        //Maybe remove this later
        val border = Paint()
        border.color = -0x1000000
        border.style = Paint.Style.STROKE
        border.strokeWidth = 5f
        paintCanvas?.drawRect(1f, 1f, 1023f, 1023f, border)

        //Set the brush properties
        brush.isAntiAlias = true
        brush.isDither = true
        brush.color = toolColor
        brush.style = Paint.Style.STROKE
        brush.strokeJoin = Paint.Join.ROUND
        brush.strokeCap = Paint.Cap.ROUND
        brush.strokeWidth = toolSize
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //Draw the bitmap
        bitmap?.let { canvas.drawBitmap(it, 0f, 0f, null) }
    }

    fun updateBrush() {
        brush.color = toolColor
        brush.strokeWidth = toolSize

        //Change the brush shape
        when (toolShape) {
            "PEN" -> {
                brush.strokeJoin = Paint.Join.ROUND
                brush.strokeCap = Paint.Cap.ROUND
            }
        }
    }

    //Function to draw on the canvas
    fun drawOnCanvas(x: Float, y: Float) {
        paintCanvas?.drawLine(lastX, lastY, x, y, brush)

        //Set the last position
        lastX = x
        lastY = y

        //Reset the canvas
        invalidate()
    }

    //Function to end the drawing
    fun endDrawing() {
        lastX = 0f
        lastY = 0f
    }

    //Get user's touch position
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                drawOnCanvas(x, y)
            }
            MotionEvent.ACTION_UP -> {
                endDrawing()
            }
        }
        return super.onTouchEvent(event)
    }
}