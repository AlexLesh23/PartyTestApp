package com.bsc.msc.testapp.data.repository

import com.bsc.msc.testapp.data.repository.network.response.ApiResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface PartyRepository {
    fun getPartyInfo(): Observable<ApiResponse>
    fun getPartyInfo2(): Observable<ApiResponse>
}