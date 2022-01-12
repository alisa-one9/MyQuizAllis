package com.example.myquizallis.dataRemote

import com.example.myquizallis.domain.TriviaCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface QuizApi {

    @GET("api_category.php")
    suspend fun getCategory(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String = "multiple"
    ): Call<TriviaCategoriesResponse>




}