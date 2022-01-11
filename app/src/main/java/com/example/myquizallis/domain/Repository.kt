package com.example.myquizallis.domain

import androidx.lifecycle.LiveData

interface Repository {

    fun getCategory(): LiveData<TriviaCategoriesResponse>


}