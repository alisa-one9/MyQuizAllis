package com.example.myquizallis

import android.app.Application
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.Room.databaseBuilder

import com.example.myquizallis.data.QuizApi

import com.example.myquizallis.data.Retrofit
import com.example.myquizallis.domain.Repository

class App: Application() {


    companion object{

        lateinit var  retrofit: Retrofit
        lateinit var api: QuizApi
    }
    override fun onCreate() {
        super.onCreate()

        retrofit =Retrofit()

              api = retrofit.provideApi()!!
    }
}