package com.example.myquizallis.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myquizallis.models.RoomModel

@Database(entities = [RoomModel::class],version =1)
abstract class DataBase: RoomDatabase() {

    abstract  fun getDao(): Dao
}