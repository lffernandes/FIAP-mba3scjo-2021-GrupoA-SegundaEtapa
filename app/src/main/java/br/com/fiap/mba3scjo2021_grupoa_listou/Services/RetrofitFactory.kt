package br.com.fiap.mba3scjo2021_grupoa_listou.Services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory{

        private const val URL: String = "https://listou-api.herokuapp.com/api/"

       private val client = OkHttpClient.Builder().build()

        private val retrofit = Retrofit.Builder()
                    .baseUrl(URL)
            //.client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        fun <T> buildService(service: Class<T>) : T? {
            return retrofit?.create(service)
        }
    }
