package com.tabletopsoft.videogamelist

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.ImageRequest
import com.tabletopsoft.videogamelist.data.User
import com.tabletopsoft.videogamelist.data.VGLImageAsset
import com.tabletopsoft.videogamelist.data.VideoGame
import io.reactivex.Flowable
import io.reactivex.Single
import java.io.File
import java.io.FileOutputStream

class VGLNetworkService(private val context: Context) : VGLService {

    private val requestQueue : RequestQueue

    init {
        val cache = DiskBasedCache(context.cacheDir, 1024 * 1024)
        val network = BasicNetwork(HurlStack())

        requestQueue = RequestQueue(cache, network)

        requestQueue.start()
    }

    override fun cacheImage(imageAsset: VGLImageAsset, maxWidth: Int, maxHeight: Int) =
            downloadImage(imageAsset, maxWidth, maxHeight, context.cacheDir)

    override fun saveImage(imageAsset: VGLImageAsset, maxWidth: Int, maxHeight: Int) =
            downloadImage(imageAsset, maxWidth, maxHeight, context.filesDir)

    override fun gameList(userID: Int): Flowable<VideoGame> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userData(): Single<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun friends(): Single<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun games(): Flowable<VideoGame> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Returns a {@link Single<Bitmap>} that will respond with a Single
     */
    private fun downloadImage(imageAsset: VGLImageAsset, maxWidth: Int, maxHeight: Int, dir: File) =
        imageAsset.localPath?.let { Single.just(BitmapFactory.decodeFile(it)) } ?:
        Single.create { emitter ->
            val responseListener = Response.Listener<Bitmap> {
                emitter.onSuccess(it)
                imageAsset.localPath = saveToDir(it, dir, imageAsset.imageId)
            }

            val errorListener = Response.ErrorListener {
                emitter.onError(it)
            }

            val request = ImageRequest(
                imageAsset.imageUrl,
                responseListener,
                maxWidth,
                maxHeight,
                ImageView.ScaleType.FIT_CENTER,
                Bitmap.Config.ARGB_8888,
                errorListener
            )

            requestQueue.add(request)
        }

    /**
     * Saves bitmap to the specified location and returns the
     * full path where the file is located
     *
     * @param   bitmap  the bitmap to save
     * @param   dir     directory to save the file
     * @param   name    name of the file
     */
    private fun saveToDir(bitmap: Bitmap, dir: File, name: String): String {
        val file = File(dir, name)
        val outputStream = FileOutputStream(file)

        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream)

        return file.absolutePath
    }


}