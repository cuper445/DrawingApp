package com.example.drawingapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class CanvasFragment : Fragment(R.layout.canvas) {
    //Add the canvasView class
    private lateinit var canvasView: CanvasView

    //Initialize the canvasView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        canvasView = view.findViewById(R.id.canvasView)
    }
}