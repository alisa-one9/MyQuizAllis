package com.example.myquizallis.presentation.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myquizallis.R
import com.example.myquizallis.databinding.FragmentDashboardBinding
import com.example.myquizallis.presentation.home.HomeViewModel

class DashboardFragment : Fragment() {

    private lateinit var  binding: FragmentDashboardBinding
    private lateinit var dashModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(layoutInflater)
       return binding.root
    }



}