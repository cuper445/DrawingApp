package com.example.drawingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.graphics.Color

class ViewModel: ViewModel() {
    private val toolSize = 5
    private val toolColor = Color.argb(255, 255, 0, 0)
    private val toolShape = "PEN"

}