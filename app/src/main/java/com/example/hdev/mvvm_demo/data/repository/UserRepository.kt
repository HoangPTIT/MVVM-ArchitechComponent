package com.example.hdev.mvvm_demo.data.repository

import com.example.hdev.mvvm_demo.data.model.User
import com.example.hdev.mvvm_demo.data.remote.UserRemoteDataSource
import io.reactivex.Single

class UserRepository(private val userDataSource: UserRemoteDataSource) : UserDataSource.Remote {
    override fun getUsers(): Single<List<User>> {
        return userDataSource.getUsers()
    }
}
