package com.example.roomtests.database.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "user_name")
    val firstName: String?,
    @ColumnInfo(name = "user_lastname")
    val lastName: String?,
    @ColumnInfo(name = "user_age")
    val userAge: Int?
): Parcelable