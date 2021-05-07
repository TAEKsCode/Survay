package com.onix.internship.survay.data.database.tables.auth

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auth")
data class Auth(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "authId")
    var authId: Long = 0L,
    @ColumnInfo(name = "authUserId")
    var authUserId: Long = 0L
)