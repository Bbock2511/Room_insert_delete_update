package com.example.roomtests.database.repository

import androidx.lifecycle.LiveData
import com.example.roomtests.database.daos.UserDao
import com.example.roomtests.database.models.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.getAllUsers()

    fun addUser(user: User){
        userDao.insertUser(user)
    }
    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
    fun updateUser(user: User){
        userDao.updateUser(user)
    }
}