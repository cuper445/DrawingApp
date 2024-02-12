package com.example.drawingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

import com.example.drawingapp.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val myViewModel : ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbarSizeFragment = Toolbar
        val toolbarColorFragment = idk
        val toolbarToolFragment = idk
        val toolbarFileFragment = idk

        binding.colorButton.setOnClickListener{
            val fTrans = supportFragmentManager.beginTransaction()
            fTrans.replace(R.id.expandedToolbarFragmentView, toolbarColorFragment)
            fTrans.addToBackStack(null)
            fTrans.commit()
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
        binding.fileButton.setOnClickListener{
            val fTrans = supportFragmentManager.beginTransaction()
            fTrans.replace(R.id.expandedToolbarFragmentView, toolbarFileFragment)
            fTrans.addToBackStack(null)
            fTrans.commit()
        }

    }


}