package com.example.myquizallis.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myquizallis.App
import com.example.myquizallis.R
import com.example.myquizallis.databinding.FragmentHommeBinding
import com.example.myquizallis.domain.TriviaCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class HommeFragment : Fragment() {

    private lateinit var binding: FragmentHommeBinding
    private val homeModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHommeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start()
    }



    private fun start() {
            App.api.getCategory().enqueue(object :Callback<TriviaCategoriesResponse>{
                override fun onResponse(
                    call: Call<TriviaCategoriesResponse>,
                    response: Response<TriviaCategoriesResponse>
                ) {
                    val data = response.body()
                   var nameCategory = arrayListOf<String>()
                    response.body()?.triviaCategories?.forEach {
                        nameCategory.add(it.name)
                    }
                    val adapter = ArrayAdapter(
                        requireContext(),
                        R.layout.simple_spiner_item,
                        nameCategory
                    )
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                    binding.spinner1.setAdapter(adapter)
                }

                override fun onFailure(call: Call<TriviaCategoriesResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })


    }

}