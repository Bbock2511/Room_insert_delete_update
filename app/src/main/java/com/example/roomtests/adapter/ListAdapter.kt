package com.example.roomtests.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtests.ListFragmentDirections
import com.example.roomtests.database.models.User
import com.example.roomtests.database.viewmodel.UserViewModel
import com.example.roomtests.databinding.UserViewAdapterBinding

class ListAdapter(private val userViewModel: UserViewModel) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemUser = UserViewAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemUser)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.userId.text = currentUser.uid.toString()
        holder.userName.text = currentUser.firstName
        holder.userLastName.text = currentUser.lastName
        holder.userAge.text = currentUser.userAge.toString()

        holder.itemView.rootView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToEditUserFragment(currentUser)
            holder.itemView.findNavController().navigate(action)
        }

        holder.deleteUserButton.setOnClickListener {
            deleteUser(currentUser)
        }


    }
    class MyViewHolder(binding: UserViewAdapterBinding): RecyclerView.ViewHolder(binding.root){
        val userId = binding.userId
        val userName = binding.userName
        val userAge = binding.userAge
        val userLastName = binding.lastName
        val deleteUserButton = binding.deleteUserButton
    }

    private fun deleteUser(user: User){
        userViewModel.removeUser(user)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}
