package com.tabletopsoft.videogamelist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tabletopsoft.videogamelist.R
import com.tabletopsoft.videogamelist.VideoGameListViewModel
import com.tabletopsoft.videogamelist.adapters.VideoGameRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_video_game_list.*

class VideoGameListFragment : Fragment() {
    private lateinit var viewModel: VideoGameListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_video_game_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val nav = findNavController()

        viewModel = ViewModelProviders.of(this).get(VideoGameListViewModel::class.java)

        list.layoutManager = LinearLayoutManager(context)

        list.adapter = VideoGameRecyclerViewAdapter(viewModel.games) {
            nav.navigate(R.id.action_navigation_list_to_videoGameEntryFragment)
        }
    }
}
