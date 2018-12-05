package com.tabletopsoft.videogamelist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import com.tabletopsoft.videogamelist.data.VideoGame

import kotlinx.android.synthetic.main.list_item_video_game.view.*

/**
 * [RecyclerView.Adapter] that can display a [VideoGame] and makes a call to the
 * specified listener.
 */
class VideoGameRecyclerViewAdapter(
    private val mValues: List<VideoGame>,
    private val mListener: ((VideoGame) -> Unit)?
) : androidx.recyclerview.widget.RecyclerView.Adapter<VideoGameRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as VideoGame
            mListener?.invoke(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_video_game, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = mValues[position]
        holder.idView.text = game.id.toString()
        holder.contentView.text = game.name

        with(holder.view) {
            tag = game
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val idView: TextView = view.item_number
        val contentView: TextView = view.content
    }
}
