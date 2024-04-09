package com.example.coroutineproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private var bind = MainViewModel()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name1: TextView

        init {
            name1 = itemView.findViewById(R.id.name)
        }
        init {

            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition + 1

                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
       }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        Log.i("help", "it works")
        val nameArr = bind.names.get(i)
        viewHolder.name1.text = nameArr
    }

    override fun getItemCount(): Int {
        return bind.names.size
    }
}
