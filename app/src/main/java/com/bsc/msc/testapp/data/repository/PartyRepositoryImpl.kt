package com.bsc.msc.testapp.data.repository

import com.bsc.msc.testapp.data.repository.network.PartyApiImpl
import com.bsc.msc.testapp.data.repository.network.response.ApiResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PartyRepositoryImpl @Inject constructor(private val partyApiImpl: PartyApiImpl) : PartyRepository {
    override fun getPartyInfo(): Observable<ApiResponse> = partyApiImpl.getPartyInfo()
    override fun getPartyInfo2(): Observable<ApiResponse> = partyApiImpl.getPartyInfo2()
}