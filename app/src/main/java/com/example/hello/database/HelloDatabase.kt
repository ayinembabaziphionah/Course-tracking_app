package com.example.hello.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hello.Courses

@Database(entities = arrayOf(Courses::class), version = 1)
abstract class HelloDatabase {
    abstract fun courseDao(): courseDao
}