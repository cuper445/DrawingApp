package com.example.drawingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.example.drawingapp.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape



class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val myViewModel : DrawViewModel by viewModels()

    private var defaultColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()


        setContentView(R.layout.activity_main)

        val toolbarSizeFragment = ToolbarSizeFragment()
        val toolbarColorFragment = ToolbarColorFragment()
        val toolbarToolFragment = ToolbarToolFragment()
        val toolbarFileFragment = ToolbarFileFragment()

        //Create canvas
        val canvasFragment = CanvasFragment()
        val fTrans = supportFragmentManager.beginTransaction()
        fTrans.add(R.id.canvasFragmentView, canvasFragment)
        fTrans.commit()

        binding.colorButton.setOnClickListener{
//            val fTrans = supportFragmentManager.beginTransaction()
//            fTrans.replace(R.id.expandedToolbarFragmentView, toolbarColorFragment)
//            fTrans.addToBackStack(null)
//            fTrans.commit()
            ColorPickerDialog
                .Builder(this)
                .setTitle("Pick Theme")
                .setColorShape(ColorShape.CIRCLE)
                .setDefaultColor(defaultColor)
                .setColorListener { color, colorHex ->
                    //Set tool color
                    myViewModel.setToolColor(color)
                }
                .show()
        }
        binding.toolButton.setOnClickListener{
            val fTrans = supportFragmentManager.beginTransaction()
            fTrans.replace(R.id.expandedToolbarFragmentView, toolbarToolFragment)
            fTrans.addToBackStack(null)
            fTrans.commit()
        }
        binding.sizeButton.setOnClickListener{
            val fTrans = supportFragmentManager.beginTransaction()
            fTrans.replace(R.id.expandedToolbarFragmentView, toolbarSizeFragment)
            fTrans.addToBackStack(null)
            fTrans.commit()
        }
//        binding.fileButton.setOnClickListener{
//            val fTrans = supportFragmentManager.beginTransaction()
//            fTrans.replace(R.id.expandedToolbarFragmentView, toolbarFileFragment)
//            fTrans.addToBackStack(null)
//            fTrans.commit()
//        }

        setContentView(binding.root)

    }


}