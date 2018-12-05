package com.tabletopsoft.videogamelist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface VideoGameDao {
    @Query(value = "SELECT * FROM video_games")
    fun all() : Observable<List<VideoGame>>

    @Query(
        value = "SELECT vg.* " +
                "FROM video_games AS vg " +
                "JOIN user_video_game AS uvg " +
                "ON vg.id = uvg.video_game_id " +
                "WHERE uvg.user_id = :id"
    )
    fun user(id: Int) : Observable<List<VideoGame>>

    @Query(value = "SELECT * FROM video_games WHERE publisher_id = :id")
    fun publisher(id: Int) : Observable<List<VideoGame>>

    @Query(value = "SELECT * FROM video_games WHERE id = :id")
    fun find(id: Int) : Observable<VideoGame>
}