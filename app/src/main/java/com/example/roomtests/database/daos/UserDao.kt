package com.example.roomtests.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomtests.database.models.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(vararg user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Update
    fun updateUser(user: User)

    @Query("SELECT COUNT(uid) FROM users")
    fun getTotalItems(): Long

}