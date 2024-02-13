package com.example.drawingapp
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.drawingapp.databinding.ToolbarColorBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape

class ToolbarColorFragment: Fragment() {
   private val binding: ToolbarColorBinding by lazy{ToolbarColorBinding.inflate((layoutInflater))}
    private val myViewModel : DrawViewModel by activityViewModels()
    private var clickCallback : () -> Unit = {}

    private var defaultColor = 0

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //https://github.com/Dhaval2404/ColorPicker
        ColorPickerDialog
            .Builder(requireContext())
            .setTitle("Pick Theme")
            .setColorShape(ColorShape.CIRCLE)
            .setDefaultColor(defaultColor)
            .setColorListener { color, colorHex ->
                //Set tool color
                myViewModel.setToolColor(color)
            }
            .show()

        return binding.root
    }

}