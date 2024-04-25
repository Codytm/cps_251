package com.example.contactproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContactListAdapter(private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var contactList: List<Contact>? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val item1 = holder.item1
        val item2 = holder.item2
        val item3 = holder.item3
        contactList.let {
            item1.text = it!![listPosition].contactName
            item2.text = it!![listPosition].contactPhone

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item1: TextView = itemView.findViewById(R.id.contactName)
        var item2: TextView = itemView.findViewById(R.id.contactPhone)
        var item3: ImageButton = itemView.findViewById(R.id.deleteBtn)
    }

}