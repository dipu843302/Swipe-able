package com.example.swipe_able.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swipe_able.R
import com.example.swipe_able.model.Data
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewPagerAdapter(private val list:List<Data>):RecyclerView.Adapter<ViewPagerAdapter.Pager_ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager_ViewHolder {
     val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return Pager_ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Pager_ViewHolder, position: Int) {
      val text=list[position]
        holder.setData(text)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class Pager_ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun setData(data: Data){
            itemView.apply {
                tvText.setText(data.text)
            }
        }
    }
}