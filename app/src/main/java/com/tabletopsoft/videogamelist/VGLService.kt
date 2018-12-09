package com.tabletopsoft.videogamelist

import android.graphics.Bitmap
import com.tabletopsoft.videogamelist.data.User
import com.tabletopsoft.videogamelist.data.VGLImageAsset
import com.tabletopsoft.videogamelist.data.VideoGame
import io.reactivex.Flowable
import io.reactivex.Single

interface VGLService {
    fun cacheImage(imageAsset: VGLImageAsset, maxWidth: Int, maxHeight: Int) : Single<Bitmap>
    fun saveImage(imageAsset: VGLImageAsset, maxWidth: Int, maxHeight: Int) : Single<Bitmap>
    fun gameList(userID: Int) : Flowable<VideoGame>
    fun userData() : Single<User>
    fun friends() : Single<List<User>>
    fun games() : Flowable<VideoGame>
}