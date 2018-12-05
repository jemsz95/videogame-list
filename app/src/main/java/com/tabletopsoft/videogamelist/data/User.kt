package com.tabletopsoft.videogamelist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    val username: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "join_date") val joinDate: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}