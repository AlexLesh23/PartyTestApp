package com.bsc.msc.testapp.repository

import android.content.Context
import com.bsc.msc.testapp.network.model.response.ApiResponse
import com.bsc.msc.testapp.network.APIService
import io.reactivex.rxjava3.core.Single
import org.koin.core.context.GlobalContext.get
import java.io.IOException
import java.io.InputStream

class PartyRepository(private val context: Context) {
    private val apiService = get().koin.get<APIService>()

    fun getPartyInfo(): Single<ApiResponse> = apiService.getParty()


    private fun getDataFromAssets(): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open("data.json")
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