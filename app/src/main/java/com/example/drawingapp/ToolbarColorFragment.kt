package com.example.drawingapp
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.drawingapp.databinding.ToolbarColorBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel

class ToolbarColorFragment: Fragment() {
   private val binding: ToolbarColorBinding by lazy{ToolbarColorBinding.inflate((layoutInflater))}
    private val myViewModel : DrawViewModel by activityViewModels()
    private var clickCallback : () -> Unit = {}

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return binding.root
    }

}