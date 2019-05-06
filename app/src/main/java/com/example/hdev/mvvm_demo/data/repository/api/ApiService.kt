package com.example.hdev.mvvm_demo.data.repository.api

import com.example.hdev.mvvm_demo.data.model.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/api/v1/employees")
    fun getUsers(): Single<List<User>>

    @POST("/api/v1/create")
    @FormUrlEncoded
    fun insertUser(
        @Field("id") id: String,
        @Field("employee_name") employee_name: String,
        @Field("employee_salary") employee_salary: String,
        @Field("employee_age") employee_age: String,
        @Field("profile_image") profile_image: String
    ): Observable<Boolean>
}
