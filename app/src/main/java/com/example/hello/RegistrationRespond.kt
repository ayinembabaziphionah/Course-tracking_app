package com.example.hello
data class RegistrationResponse(
    @Student.SerializedName("message") var message: String,
    @Student.SerializedName("student") var student: Student
) {
}