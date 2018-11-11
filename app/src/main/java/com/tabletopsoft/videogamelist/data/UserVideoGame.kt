package com.tabletopsoft.videogamelist.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(
    tableName = "user_video_game",
    foreignKeys = [
        ForeignKey(entity = VideoGame::class, parentColumns =  ["id"], childColumns =  ["video_game_id"]),
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])
    ],
    primaryKeys = [
        "video_game_id",
        "user_id"
    ]
)
data class UserVideoGame(
    @ColumnInfo(name = "video_game_id")val videoGameId: Int,
    @ColumnInfo(name = "user_id") val userId: Int
)