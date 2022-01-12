package com.example.myquizallis

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myquizallis.domain.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel(){

    fun getAllQuestions(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): LiveData<Resource<QuizModel>> {
        return repository.getAllQuestions(amount, category, difficulty, type)
    }

    fun saveQuestions(roomResult: RoomResult) = viewModelScope.launch {
        repository.upsert(roomResult)
    }

    fun getSavedQuestions() = repository.getSavedQuestions()

    fun deleteQuestions(roomResult: RoomResult) = viewModelScope.launch {
        repository.deleteResults(roomResult)
    }
}