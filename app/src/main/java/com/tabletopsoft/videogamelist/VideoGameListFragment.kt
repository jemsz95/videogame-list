package com.tabletopsoft.videogamelist

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_video_game_list, container, false)
        val app = activity?.application

        if(app is VGLApplication) {
            val videoGameDao = app.database?.videoGameDao()
            val user = app.user

            if(user != null) {
                videoGameDao?.user(user.id)?.observe(this, Observer {
                    val data = it ?: emptyList()

                    // Set the adapter
                    if (view is RecyclerView) {
                        with(view) {
                            layoutManager = LinearLayoutManager(context)
                            adapter = VideoGameRecyclerViewAdapter(data, listener)
                        }
                    }
                })
            }
        }

        return view
    }

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
