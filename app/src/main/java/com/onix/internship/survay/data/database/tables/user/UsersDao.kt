package com.onix.internship.survay.data.database.tables.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsersDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * from users WHERE login = :login AND password = :password")
    suspend fun get(login: String, password: String): User?

    @Query("SELECT * FROM users ORDER BY userId ASC")
    fun getAllUsers(): List<User>

    @Update
    suspend fun  update(user: User)

}