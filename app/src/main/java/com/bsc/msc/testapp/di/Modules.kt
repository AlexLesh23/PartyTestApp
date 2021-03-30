package com.bsc.msc.testapp.di

import com.bsc.msc.testapp.repository.PartyRepository
import com.bsc.msc.testapp.viewmodel.PartyViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel {
        PartyViewModel(get())
    }

}

val repoModule = module {
    factory {
        PartyRepository(androidContext())
    }
}

val networkModule = module {

    single {
        OkHttpClient.Builder().run {
            readTimeout(60L, TimeUnit.SECONDS)
            connectTimeout(60L, TimeUnit.SECONDS)
            writeTimeout(60L, TimeUnit.SECONDS)
            build()
        }
    }

    single {
        Retrofit.Builder().run {
            baseUrl("base_url")
            client(get())
            addConverterFactory(GsonConverterFactory.create())
            build()
        }
    }
}