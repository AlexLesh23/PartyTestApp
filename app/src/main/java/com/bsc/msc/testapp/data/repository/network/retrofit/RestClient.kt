package com.bsc.msc.testapp.data.repository.network.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RestClient {
    fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.69/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }
}
