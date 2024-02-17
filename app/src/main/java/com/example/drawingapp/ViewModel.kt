package com.example.drawingapp

import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.graphics.Color

class DrawViewModel: ViewModel() {
    var toolSize : MutableLiveData<Float> = MutableLiveData(5f)
    var toolColor : MutableLiveData<Int> = MutableLiveData(Color.BLACK)
    var toolShape : MutableLiveData<String> = MutableLiveData("PEN")

    var bitmap : MutableLiveData<Bitmap> = MutableLiveData(Bitmap.createBitmap(1024, 1024, Bitmap.Config.ARGB_8888))

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