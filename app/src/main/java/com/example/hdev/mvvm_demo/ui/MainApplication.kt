package com.example.hdev.mvvm_demo.ui

import android.app.Application
import com.example.hdev.mvvm_demo.di.appModule
import com.example.hdev.mvvm_demo.di.networkModule
import com.example.hdev.mvvm_demo.di.repositoryModule
import com.example.hdev.mvvm_demo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()

            androidContext(this@MainApplication)

            modules(appModule, viewModelModule, networkModule, repositoryModule)
        }
    }
}
