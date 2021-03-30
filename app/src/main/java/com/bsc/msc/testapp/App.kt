package com.bsc.msc.testapp

import android.app.Application
import com.bsc.msc.testapp.di.networkModule
import com.bsc.msc.testapp.di.repoModule
import com.bsc.msc.testapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            koin.createScope("repoScope", named("repoScope"))
            androidContext(this@App)
            modules(listOf(viewModelModule, repoModule, networkModule))
        }
    }
}