package com.example.hdev.mvvm_demo.data.remote

import com.example.hdev.mvvm_demo.data.model.User
import com.example.hdev.mvvm_demo.data.repository.UserDataSource.Remote
import com.example.hdev.mvvm_demo.data.repository.api.ApiService
import io.reactivex.Single

class UserRemoteDataSource(private val apiService: ApiService) : Remote {

    override fun getUsers(): Single<List<User>> {
        return apiService.getUsers()
    }
}
