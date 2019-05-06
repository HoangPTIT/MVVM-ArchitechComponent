package com.example.hdev.mvvm_demo.di

import com.example.hdev.mvvm_demo.ui.main.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { UserViewModel(get()) }
}
