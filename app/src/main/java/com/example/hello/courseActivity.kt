package com.example.hello

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.RoomDatabase
import com.example.hello.database.HelloDatabase
import com.example.hello.database.courseDao

private val Any.Courses: Any
    get() {}

class courseActivity {

    abstract class CoursesActivity : AppCompatActivity(), CourseItemClickListener {

        private abstract val Room: Any
        private abstract val baseContext: Context?
        lateinit var database: HelloDatabase
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_courses)
            database = Room.databaseBuilder(baseContext, HelloDatabase::class.java, "hello-db").build()
            fetchCourses()
        }



        fun fetchCourses() {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
            val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")



            val apiClient = ApiClient.buildService(ApiInterface::class.java)
            val coursesCall = apiClient.getCourse("Bearer " + accessToken)
            coursesCall.enqueue(object : RoomDatabase.Callback<CourseResponse> {
                override fun onFailure(call: ApiInterface.Call<CourseResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                    fetchCoursesFromDatabase()
                }



                fun onResponse(call: ApiInterface.Call<CourseResponse>, response: Response<CourseResponse>) {
                    if (response.isSuccessful) {
                        var courseList = response.body()?.Courses as List<Courses>
                        Thread {
                            courseList.forEach { course ->
                                database.courseDao().insertCourse(course)
                            }
                        }.start()



                        displayCourses(courseList)
                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
        }



        fun fetchCoursesFromDatabase(){
            Thread{
                val courses = database.courseDao().getAllCourses()



                runOnUiThread {
                    displayCourses(courses)
                }
            }.start()
        }



        fun displayCourses(courses: List<Courses>){
            var coursesAdapter = courseAdapter(courses, this)
            rvCourses.layoutManager = LinearLayoutManager(baseContext)
            rvCourses.adapter = coursesAdapter
        }



        override fun onItemClick(course: Courses) {
            //obtain student id from shared preferences
            //courseId = course.courseId
            //make a post request https://github.com/owuor91/registration-api
        }
    }

}

private fun courseDao.insertCourse(course: Any) {

}

private fun Any.databaseBuilder(baseContext: Context?, java: Class<HelloDatabase>, s: String): Any {

}
