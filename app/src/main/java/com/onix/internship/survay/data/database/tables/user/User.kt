package com.onix.internship.survay.data.database.tables.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    var userId: Long = 0L,
    @ColumnInfo(name = "login")
    var login: String = "",
    @ColumnInfo(name = "password")
    var password: String = "",
    @ColumnInfo(name = "firstName")
    var firstName: String = "",
    @ColumnInfo(name = "lastName")
    var lastName: String = "",
    @ColumnInfo(name = "role")
    var role: Int = 0
)