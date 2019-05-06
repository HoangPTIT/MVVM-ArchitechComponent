package com.example.hdev.mvvm_demo.di

import com.example.hdev.mvvm_demo.data.repository.api.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { createApiService(DatasourceProperties.BASE_URL) }
}

private fun createApiService(base_url: String): ApiService {
    val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(base_url)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
    return retrofit.create(ApiService::class.java)
}

object DatasourceProperties {
    const val BASE_URL = "http://dummy.restapiexample.com"
}
