package com.example.hello.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hello.Courses

@Dao
interface courseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourses(Course: Courses)

    @Query("""SELECT * FROM Courses""")
    fun  getAllCourses(): List<Courses>
}