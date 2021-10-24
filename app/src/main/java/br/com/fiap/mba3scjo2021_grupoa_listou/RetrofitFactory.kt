package br.com.fiap.mba3scjo2021_grupoa_listou

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    val URL: String = "http://localhost:3000/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitService() : RetrofitService {
        return retrofitFactory.create(RetrofitService::class.java)
    }
}