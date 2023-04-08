package com.mrprogrammer.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName =  "Sample")
data class Sample(
    @PrimaryKey(autoGenerate = true)
    val id : Int ?,

    @ColumnInfo(name = "name")
    var name : String,

)
