package com.example.imtihon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imtihon.R
import com.example.imtihon.model.Member

class CustomAdapter(var members: ArrayList<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_view, parent, false)
        return CustomvViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member: Member = members[position]
        if (holder is CustomvViewHolder) {
            holder.tv_name.setText(member.name)
            holder.iv_image.setImageResource(member.int)
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    inner class CustomvViewHolder internal constructor(private val view: View) :
        RecyclerView.ViewHolder(
            view
        ) {
        val tv_name: TextView
        val iv_image: ImageView

        init {
            tv_name = view.findViewById(R.id.tv_name)
            iv_image = view.findViewById(R.id.iv_image)
        }
    }

}