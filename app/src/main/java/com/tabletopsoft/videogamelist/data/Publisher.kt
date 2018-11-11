package com.tabletopsoft.videogamelist.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "publishers")
data class Publisher (val name: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}