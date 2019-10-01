package com.srivathsan.sample1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.srivathsan.sample1.R
import com.srivathsan.sample1.model.User
import com.srivathsan.sample1.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val userList = ArrayList<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        getUsers()
    }

    private fun initialize() {
        val layoutManager = LinearLayoutManager(this)
        rvUsers.layoutManager = layoutManager
        adapter = UserAdapter(userList)
        rvUsers.adapter = adapter

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    private fun getUsers() {
        userViewModel.getUserViewModel().observe(this, Observer {
            if(it != null) {
                userList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }
}
