package com.tabletopsoft.videogamelist.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tabletopsoft.videogamelist.R

class ListTabFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View
        = inflater.inflate(R.layout.fragment_list_tab, container, false)
}
