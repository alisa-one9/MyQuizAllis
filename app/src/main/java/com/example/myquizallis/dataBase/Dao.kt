package com.example.myquizallis.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myquizallis.models.RoomModel

interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(roomResult: RoomModel):Long

    @Query("SELECT * FROM questions")
    fun getAllResults(): LiveData<List<RoomModel>>

    @Delete
    suspend fun deleteResult(roomResult: RoomModel)
}