package com.tabletopsoft.videogamelist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "publishers")
data class Publisher (val name: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}