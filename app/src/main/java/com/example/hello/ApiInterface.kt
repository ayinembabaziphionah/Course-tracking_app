package com.example.hello

import android.telecom.Call as Call1


interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>

    annotation class Body

    class RequestBody {

    }

    class Call<T> {
        fun enqueue(any: Any) {

        }

    }

    annotation class POST(val value: String)
}