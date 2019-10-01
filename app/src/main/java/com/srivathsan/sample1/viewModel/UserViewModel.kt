package com.srivathsan.sample1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.srivathsan.sample1.model.User
import com.srivathsan.sample1.repository.UserRepository

class UserViewModel : ViewModel() {
    
    fun getUserViewModel(): MutableLiveData<List<User>> {
        return UserRepository().getUsers()
    }
}