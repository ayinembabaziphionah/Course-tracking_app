package com.example.hello

import android.app.TaskStackBuilder.create
import android.content.IntentFilter.create
import java.net.URI.create

object ApiClient {
    var client = OkHttpClient.Builder().build()

    class OkHttpClient {
        class Builder {

        }

    }

    var retrofit: Any

        get() {
            val build = Retrofit.Builder()
                .baseUrl("https://courses-service.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.()
                .client(client)
                .build()
            return build
        }
        set(value) = TODO()

    class GsonConverterFactory {

    }

    class Retrofit {
        class Builder {
            fun baseUrl(s: String): Any {
                TODO("Not yet implemented")
            }

        }

    }

    fun <T> buildService(service: Class<T>) {

        return retrofit.create(service)
    }
}

private fun <T> Any.create(service: Class<T>) {}

private fun Any.build(): Any {
    TODO("Not yet implemented")
}

private fun Any.client(client: Any): Any {
    TODO("Not yet implemented")
}

private fun Any.addConverterFactory(create: Any) {

}
