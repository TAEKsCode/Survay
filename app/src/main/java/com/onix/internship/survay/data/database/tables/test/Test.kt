package com.onix.internship.survay.data.database.tables.test

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tests")
data class Test(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "testId")
    var testId: Long = 0L,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "descrpition")
    var description: String = ""
)