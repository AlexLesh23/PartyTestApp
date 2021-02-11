package com.bsc.msc.testapp.repository

import android.content.Context
import com.bsc.msc.testapp.model.ApiResponse
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.core.Single
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PartyRepository @Inject constructor(@ApplicationContext private val context: Context) {

    fun getPartyInfo(): Single<ApiResponse> {
        return Single.create {
            try {
                val gson = Gson()
                val apiResponse = gson.fromJson(getDataFromAssets(), ApiResponse::class.java)
                it.onSuccess(apiResponse)
            } catch (ex: Exception) {
                it.onError(ex)
            }
        }
    }

    private fun getDataFromAssets(): String? {
        var json: String? = null
        try {
            val inputStream: InputStream =context.assets.open("data.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return json
    }
}