package com.srivathsan.sample1.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.srivathsan.sample1.model.User
import com.srivathsan.sample1.service.ApiService
import com.srivathsan.sample1.service.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private val retrofit = RetrofitClientInstance.getRetrofitInstance()
    private var service: ApiService = retrofit!!.create(ApiService::class.java)

    fun getUsers() : MutableLiveData<List<User>>{
        val userList = MutableLiveData<List<User>>()
        val call = service.getUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    Log.i("response = ", response.body().toString())
                    userList.value = response.body()!!
                }
            }
        })
        return userList
    }
}