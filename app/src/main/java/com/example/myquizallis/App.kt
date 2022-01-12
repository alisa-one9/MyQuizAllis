package com.example.myquizallis

import android.app.Application

import com.example.myquizallis.dataRemote.QuizApi

import com.example.myquizallis.dataRemote.Retrofit

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