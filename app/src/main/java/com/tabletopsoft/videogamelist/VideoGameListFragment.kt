package com.tabletopsoft.videogamelist

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tabletopsoft.videogamelist.data.VideoGame

class VideoGameListFragment : Fragment() {

    private var listener: ((VideoGame) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_video_game_list, container, false)

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        //const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(onVideoGameClick: ((VideoGame) -> Unit)? = null) =
            VideoGameListFragment().apply {
                arguments = Bundle().apply {
                    //putInt(ARG_COLUMN_COUNT, 1)
                }

                listener = onVideoGameClick
            }
    }
}
