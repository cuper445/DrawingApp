package com.example.drawingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.graphics.Color

class DrawViewModel: ViewModel() {
    private var toolSize = 5
    private var toolColor = Color.argb(255, 255, 0, 0)
    private var toolShape = "PEN"

    fun setToolColor(color: Int) {
        toolColor = color
    }
}