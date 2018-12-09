package com.tabletopsoft.videogamelist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "developers")
data class Developer (val name: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}