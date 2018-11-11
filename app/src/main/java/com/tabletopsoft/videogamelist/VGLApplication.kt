package com.tabletopsoft.videogamelist

import android.app.Application
import android.arch.persistence.room.Room
import com.tabletopsoft.videogamelist.data.User
import com.tabletopsoft.videogamelist.data.VGLDatabase

class VGLApplication : Application() {
    var database : VGLDatabase? = null
    var user : User? = null

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, VGLDatabase::class.java, "vgl").build()
    }
}