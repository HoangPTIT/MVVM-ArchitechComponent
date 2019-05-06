package com.example.hdev.mvvm_demo.di

import com.example.hdev.mvvm_demo.data.remote.UserRemoteDataSource
import com.example.hdev.mvvm_demo.data.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { UserRemoteDataSource(get()) }

    single { UserRepository(get()) }
}
