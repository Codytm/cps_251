package com.example.recycledemo


import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycledemo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var dataBind = Data()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = dataBind.titles[Random.nextInt(0, dataBind.titles.size)]
        viewHolder.itemDetail.text = dataBind.details[Random.nextInt(0, dataBind.details.size)]
        viewHolder.itemImage.setImageResource(dataBind.images[Random.nextInt(0, dataBind.images.size)])
//        viewHolder.itemTitle.text = dataBind.titles[dataBind.rnd1]
//        viewHolder.itemDetail.text = dataBind.details[dataBind.rnd2]
//        viewHolder.itemImage.setImageResource(dataBind.images[dataBind.rnd3])
    }

    override fun getItemCount(): Int {
        return dataBind.titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View  ->
                val position: Int = adapterPosition + 1

                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()

            }
        }


    }

}
