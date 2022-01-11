package com.example.myquizallis.data

import com.example.myquizallis.domain.TriviaCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

public interface QuizApi {

    @GET("api_category.php")
    fun getCategory(): Call<TriviaCategoriesResponse>


}