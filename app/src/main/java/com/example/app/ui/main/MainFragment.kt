package com.example.app.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonA.setOnClickListener {
            val newColors = listOf(
                Color.RED,
                Color.GREEN,
                Color.BLUE
            )
            binding.imageView.setColors(newColors)
            binding.imageViewSolid.setColors(newColors)
            binding.imageView3.setColors(newColors)
        }
    }

    companion object {

        fun newInstance() = MainFragment()
    }
}
