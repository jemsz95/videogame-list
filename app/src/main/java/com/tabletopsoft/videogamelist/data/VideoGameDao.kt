package com.tabletopsoft.videogamelist.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface VideoGameDao {
    @Query(value = "SELECT * FROM video_games")
    fun all() : LiveData<List<VideoGame>>

    @Query(
        value = "SELECT vg.* " +
                "FROM video_games AS vg " +
                "JOIN user_video_game AS uvg " +
                "ON vg.id = uvg.video_game_id " +
                "WHERE uvg.user_id = :id"
    )
    fun user(id: Int) : LiveData<List<VideoGame>>

    @Query(value = "SELECT * FROM video_games WHERE publisher_id = :id")
    fun publisher(id: Int) : LiveData<List<VideoGame>>

    @Query(value = "SELECT * FROM video_games WHERE id = :id")
    fun find(id: Int) : VideoGame
}