package com.example.roomdatabase.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.Dao.StudentDao
import com.example.roomdatabase.Entity.Student


@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
}