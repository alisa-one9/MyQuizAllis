package com.example.myquizallis.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.room.Database
import com.example.myquizallis.dataBase.DataBase
import com.example.myquizallis.dataRemote.QuizApi
import com.example.myquizallis.dataRemote.Retrofit
import com.example.myquizallis.models.RoomModel
import com.example.myquizallis.network.Resource
import kotlinx.coroutines.Dispatchers

interface Repository (val db: DataBase){

    private var quizApi: QuizApi = Retrofit.create()

    fun getCategory(amount:Int,category:Int,difficulty:String,type:String)
    : LiveData<TriviaCategoriesResponse> = liveData(Dispatchers.IO){
        emit(Resource.loading(null))

        val response = quizApi.getCategory(amount, category, difficulty,type)

        emit(
            if (response.isSuccessful)
                Resource.success(response.body(), response.code())
            else
                Resource.error(response.message(), response.body(), response.code())
        )
    }

    suspend fun upsert(roomResult: RoomModel) = db.getDao().upsert(roomResult)

    fun getSavedQuestions() = db.getDao().getAllResults()

    suspend fun deleteResults(roomResult: RoomModel) = db.getDao().deleteResult(roomResult)
}