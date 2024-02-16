package com.example.drawingapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.graphics.Color

class DrawViewModel: ViewModel() {
    var toolSize : MutableLiveData<Float> = MutableLiveData(5f)
    var toolColor : MutableLiveData<Int> = MutableLiveData(Color.BLACK)
    var toolShape : MutableLiveData<String> = MutableLiveData("PEN")

    fun setToolColor(color: Int) {
        toolColor.value = color
    }

    fun setToolSize(size: Float) {
        toolSize.value = size
    }

    fun setToolShape(shape: String) {
        toolShape.value = shape
    }
}