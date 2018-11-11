package com.tabletopsoft.videogamelist.data

import android.arch.persistence.room.*
import java.net.URL
import java.util.Date

@Entity(
    tableName = "video_games",
    foreignKeys = [
        ForeignKey(entity = Publisher::class, parentColumns = ["id"], childColumns = ["publisher_id"])
    ],
    indices = [
        Index(value = ["developer_id"]),
        Index(value = ["publisher_id"])
    ]
)
data class VideoGame(
    val name: String,
    @ColumnInfo(name = "developer_id") val developerId: String,
    @ColumnInfo(name = "publisher_id") val publisherId: Int,
    @ColumnInfo(name = "release_date") val releaseDate: Date,
    @ColumnInfo(name = "image_url") val imageUrl: URL
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}