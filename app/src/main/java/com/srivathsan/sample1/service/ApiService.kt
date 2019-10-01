package com.srivathsan.sample1.service

import com.srivathsan.sample1.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users.json")
    fun getUsers(): Call<List<User>>
}