package com.example.hdev.mvvm_demo.data.repository

import com.example.hdev.mvvm_demo.data.model.User
import io.reactivex.Single

interface UserDataSource {
    interface Remote {
        fun getUsers(): Single<List<User>>
    }
}
