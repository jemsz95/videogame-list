package com.tabletopsoft.videogamelist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment

class ListTabFragment : Fragment() {
    var videoGameListFragment : VideoGameListFragment? = null
    var videoGameEntryFragment: VideoGameEntryFragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        val view = inflater.inflate(R.layout.fragment_list_tab, container, false)

        val navHostFragment = fragmentManager?.findFragmentById(R.id.listNav)


        if(navHostFragment != null) {
            val navController = NavHostFragment.findNavController(navHostFragment)
        }

        return view
    }
}
