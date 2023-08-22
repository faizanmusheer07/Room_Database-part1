package com.example.roomdatabase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "STUDENT")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int,
)
