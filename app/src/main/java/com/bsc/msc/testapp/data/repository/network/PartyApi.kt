package com.bsc.msc.testapp.data.repository.network

import androidx.lifecycle.LiveData
import com.bsc.msc.testapp.data.repository.network.response.ApiResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PartyApi {
    @GET("/api/party_info")
    fun getPartyInfo(): Observable<ApiResponse>
}