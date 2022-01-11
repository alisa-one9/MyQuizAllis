package com.example.myquizallis.domain

import androidx.lifecycle.LiveData

class GetCategoryUseCase(private val repository: Repository) {

    fun getCategory(): LiveData<TriviaCategoriesResponse> {

        return repository.getCategory()
    }
}