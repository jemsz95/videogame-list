package com.tabletopsoft.videogamelist

import androidx.lifecycle.ViewModel
import com.tabletopsoft.videogamelist.data.VideoGame

class VideoGameListViewModel : ViewModel() {
    val games = emptyList<VideoGame>()
}