package com.onix.internship.survay.data.database.tables.access

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entities")
data class Access(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "accessId")
    var accessId: Long = 0L,
    @ColumnInfo(name = "accessUserId")
    var userId: Long = 0L,
    @ColumnInfo(name = "accessTestId")
    var testId: Long = 0L,
    @ColumnInfo(name = "enable")
    var enable: Int = 1
)