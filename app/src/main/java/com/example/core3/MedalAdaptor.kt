package com.example.core3

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MedalAdaptor(private var medallist:MutableList<Medallist>): RecyclerView.Adapter<MedalAdaptor.MedalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.medal_layout,parent,false)
        return MedalViewHolder(view)
    }
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        medallist[position]
        val medalcount = medallist[position].totalmed()
        holder.medal.text = medalcount.toString()
        holder.country.text = medallist[position].name
        holder.ioc.text = medallist[position].ioc
        val topten = gettopten()
//        if(medallist[position].ioc in topten){
//            holder.itemView.findViewById<RecyclerView>(R.id.listmedal).setBackgroundColor(R.color.black)
//        }else{
//
//        }
    }
    inner class MedalViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val country =v.findViewById<TextView>(R.id.country)
        val ioc =v.findViewById<TextView>(R.id.ioc)
        var medal =v.findViewById<TextView>(R.id.medtotal)
    }
    override fun getItemCount(): Int {
        return medallist.size
    }
    fun gettopten():MutableList<String>{
        val topmedal = mutableListOf<String>()
        val mylist = mutableListOf<Total>()
        val c = medallist.size-1
        for(i in 0..c){
            val ioc = medallist[i].ioc
            val totalmedalcnt = medallist[1].totalmed()
            mylist.add(Total(ioc,totalmedalcnt))
        }
        mylist.sortByDescending { it.total }
        for (i in 0..9){
            topmedal.add(mylist[i].ioc)
        }
        return topmedal
    }
}
