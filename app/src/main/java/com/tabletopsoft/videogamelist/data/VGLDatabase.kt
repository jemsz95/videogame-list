package com.tabletopsoft.videogamelist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        VideoGame::class,
        User::class,
        UserVideoGame::class,
        Publisher::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class VGLDatabase: RoomDatabase() {
    abstract fun videoGameDao() : VideoGameDao
}