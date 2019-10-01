package com.srivathsan.sample1.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.srivathsan.sample1.R
import com.srivathsan.sample1.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.itemView.tv_user.text = user.name
        holder.itemView.tv_email.text = user.email
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view)
}