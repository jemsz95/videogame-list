package com.tabletopsoft.videogamelist.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

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