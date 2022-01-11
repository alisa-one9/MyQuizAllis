package com.example.myquizallis.presentation.home

import android.nfc.Tag
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myquizallis.App
import com.example.myquizallis.domain.Repository
import com.example.myquizallis.domain.TriviaCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel (private val repository: Repository): ViewModel() {

   val listCategory = MutableLiveData<List<TriviaCategoriesResponse>>()

    fun getCategory(){
        App.api.getCategory().enqueue(object: Callback<TriviaCategoriesResponse>{
            override fun onResponse(
                call: Call<TriviaCategoriesResponse>,
                response: Response<TriviaCategoriesResponse>) {

            }

            override fun onFailure(call: Call<TriviaCategoriesResponse>, t: Throwable) {
                TODO()
            }

        })

    }
}