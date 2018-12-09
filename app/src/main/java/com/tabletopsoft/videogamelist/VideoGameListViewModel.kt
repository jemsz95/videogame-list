package com.tabletopsoft.videogamelist

import androidx.lifecycle.ViewModel
import com.tabletopsoft.videogamelist.data.VideoGame
import java.net.URL
import java.util.Date

class VideoGameListViewModel : ViewModel() {
    val games = arrayListOf(
        VideoGame("Assassin's Creed: Brotherhood", 0, 0, Date(), URL(""))
    )
}