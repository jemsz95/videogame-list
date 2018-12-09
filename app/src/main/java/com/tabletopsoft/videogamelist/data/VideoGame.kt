package com.tabletopsoft.videogamelist.data

import androidx.room.*
import java.util.Date

@Entity(
    tableName = "video_games",
    foreignKeys = [
        ForeignKey(entity = Publisher::class, parentColumns = ["id"], childColumns = ["publisher_id"]),
        ForeignKey(entity = Developer::class, parentColumns = ["id"], childColumns = ["developer_id"])
    ],
    indices = [
        Index(value = ["developer_id"]),
        Index(value = ["publisher_id"])
    ]
)
data class VideoGame(
    val name: String,
    @ColumnInfo(name = "developer_id") val developerId: Int,
    @ColumnInfo(name = "publisher_id") val publisherId: Int,
    @ColumnInfo(name = "release_date") val releaseDate: Date,
    @ColumnInfo(name = "image_url") override val imageUrl: String
) : VGLImageAsset {
    @PrimaryKey(autoGenerate = true)
    val id = 0

    @ColumnInfo(name="local_path")
    override var localPath: String? = null

    override val imageId: String
        get() = "vg_" + id.toString()
}