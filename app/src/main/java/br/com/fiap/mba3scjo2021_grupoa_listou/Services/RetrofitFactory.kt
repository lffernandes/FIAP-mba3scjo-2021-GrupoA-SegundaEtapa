package br.com.fiap.mba3scjo2021_grupoa_listou.Services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object ApiFactory{

        private const val URL: String = "http://localhost:3000/"
        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
        fun <T> buildService(service: Class<T>) : T? {
            return retrofit?.create(service)
        }
    }
