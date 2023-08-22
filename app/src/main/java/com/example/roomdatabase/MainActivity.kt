package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.roomdatabase.DataBase.StudentDatabase
import com.example.roomdatabase.Entity.Student
import com.example.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var database: StudentDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database =
            Room.databaseBuilder(
                applicationContext,
                StudentDatabase::class.java,
                "StudentDb"
            )
                .build()
        GlobalScope.launch {
            database.studentDao().insertStudent(Student(0, "Faizan", 23))
        }
        database.studentDao().getAllStudent().observe(this) {
            Log.d("RoomDatabase", "onCreate: $it")
        }


    }
}