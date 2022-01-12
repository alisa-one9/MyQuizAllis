package com.example.myquizallis.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class RoomModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val correct_questions:Int,
    val total_amount:Int,
    val difficulty:String
        )