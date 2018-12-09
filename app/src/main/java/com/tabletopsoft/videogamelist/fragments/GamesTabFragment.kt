package com.tabletopsoft.videogamelist.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tabletopsoft.videogamelist.GamesTabViewModel
import com.tabletopsoft.videogamelist.R


class GamesTabFragment : Fragment() {

    companion object {
        fun newInstance() = GamesTabFragment()
    }

    private lateinit var viewModel: GamesTabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.games_tab_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GamesTabViewModel::class.java)
    }

}
