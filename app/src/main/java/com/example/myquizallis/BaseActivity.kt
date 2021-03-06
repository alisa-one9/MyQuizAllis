package com.example.myquizallis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

open class BaseActivity <VB: ViewBinding>() : AppCompatActivity() {

    protected lateinit var binding: VB
    protected abstract fun inflateBinding(from: LayoutInflater): VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflateBinding(LayoutInflater.from(this))
        setContentView(binding.root)

        setupUI()
        setupLiveData()
    }

    abstract fun setupUI()
    abstract fun setupLiveData()

}