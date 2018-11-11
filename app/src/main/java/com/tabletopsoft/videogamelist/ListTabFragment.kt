package com.tabletopsoft.videogamelist


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
// private const val ARG_PARAM1 = "param1"


/**
 * A simple [Fragment] subclass.
 * Use the [ListTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ListTabFragment : Fragment() {
    private lateinit var videoGameListFragment: VideoGameListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
        }

        videoGameListFragment = VideoGameListFragment.newInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_tab, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment ListTabFragment.
         */
        @JvmStatic
        fun newInstance() =
            ListTabFragment().apply {
                arguments = Bundle().apply {
                    //putString(ARG_PARAM1, "")
                }
            }
    }
}
