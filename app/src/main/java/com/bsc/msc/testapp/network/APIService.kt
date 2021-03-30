package com.bsc.msc.testapp.network

import com.bsc.msc.testapp.network.model.response.ApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface APIService {
    @GET("api/get_party")
    fun getParty(): Single<ApiResponse>
}