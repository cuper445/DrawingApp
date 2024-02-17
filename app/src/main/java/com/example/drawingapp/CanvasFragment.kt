package com.example.drawingapp

import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class CanvasFragment : Fragment(R.layout.canvas) {
    //Add the canvasView class
    private lateinit var canvasView: CanvasView
    private val myViewModel : DrawViewModel by activityViewModels()

    //Initialize the canvasView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        canvasView = view.findViewById(R.id.canvasView)

        //Observe the brush data
        myViewModel.toolSize.observe(viewLifecycleOwner) {
            canvasView.toolSize = it
            canvasView.updateBrush()
        }

        myViewModel.toolColor.observe(viewLifecycleOwner) {
            canvasView.toolColor = it
            canvasView.updateBrush()
        }

        myViewModel.toolShape.observe(viewLifecycleOwner) {
            canvasView.toolShape = it
            canvasView.updateBrush()
        }

        //Observe bitmap
        myViewModel.bitmap.observe(viewLifecycleOwner) {
            canvasView.bitmap = it
            canvasView.paintCanvas = Canvas(it)
        }
    }

    //Trigger when user is drawing to view
    fun drawOnCanvas(x: Float, y: Float) {
        canvasView.drawOnCanvas(x, y)
    }

    //Trigger when user is done drawing
    fun endDrawing() {
        canvasView.endDrawing()
    }
}