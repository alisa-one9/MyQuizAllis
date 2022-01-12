package com.example.myquizallis.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding


class BaseFragment<Binding : ViewBinding>
    (private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> Binding) : Fragment() {

    private var _binding: Binding? = null
    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate.invoke(inflater, container, false)
        setupLiveData()
        setupUI()
        return binding.root
    }

    abstract fun setupLiveData()
    abstract fun setupUI()
}