package com.example.hello

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
import javax.security.auth.callback.Callback
import android.widget.Toast.makeText as makeText1
import android.widget.Toast.makeText as makeText1
import android.widget.Toast.makeText as makeText1
import android.widget.Toast.makeText as makeText1
import android.widget.Toast.makeText as makeText1
import com.example.hello.RegistrationResponse as RegistrationResponse1

private val Any.message: Context?
    get() {
        TODO("Not yet implemented")
    }

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btnSignin.setOnClickListener {
            var firstName=tvFirstName.text.toString()
            var lastName=tvLastName.text.toString()
            var email=tvEmail.text.toString()
            var phoneNumber=tvPhoneNumber.text.toString()
            var password=tvPassword.text.toString()
            var confirmPassword=tvConfirmPassword.text.toString()
            Toast.makeText(baseContext,lastName,Toast.LENGTH_LONG).show()
            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("first_name", firstName)
                .addFormDataPart("last_name", lastName)
                .addFormDataPart("email", email)
                .addFormDataPart("phone_number", phoneNumber)
                .addFormDataPart("password", password)
            registerUser(requestBody as ApiInterface.RequestBody)
            Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT).show()
        }
    }


    fun registerUser(requestBody: ApiInterface.RequestBody) {
        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var registrationCall = apiClient.registerUser()(requestBody).also {
            it.enqueue(any = object : Callback {
                fun onFailure(
                    call: Call,
                    t: Throwable
                ) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                fun onResponse(
                    call: Call,
                    response: Response<RegistrationResponse>
                ) = if (response.isSuccessful) {
                    val show: Any =

                    startActivity(Intent(baseContext, MainActivity::class.java))
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            })
        }
    }

    class RegistrationResponse {

    }
}

private fun Unit.registerUser(): Any {

}

private fun Any.errorBody(): Any {
    TODO("Not yet implemented")
}

private fun Any.addFormDataPart(s: String, firstName: String) {

}

class Response<T> {
    fun body(): Any {
        TODO("Not yet implemented")
    }

    val isSuccessful: Boolean
        get() {
            TODO()
        }
}

class MainActivity {


}

class MultipartBody {
    object FORM {

    }

    class Builder {
        fun setType(form: Any): Any {
            TODO("Not yet implemented")
        }

    }

}

