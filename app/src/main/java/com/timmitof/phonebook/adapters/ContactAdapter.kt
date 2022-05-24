package com.timmitof.phonebook.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.timmitof.phonebook.App
import com.timmitof.phonebook.R
import com.timmitof.phonebook.models.PhoneNumber

class ContactAdapter(private val users: List<PhoneNumber>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.photo_recycler)
        val name: TextView = view.findViewById(R.id.tvName)
        val phoneNumber: TextView = view.findViewById(R.id.tvPhoneNumber)
        val deleteBtn: ImageButton = view.findViewById(R.id.delete_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = users[position]
        holder.name.text = item.name
        holder.phoneNumber.text = item.phoneNumber
        holder.deleteBtn.setOnClickListener { App.instance?.getDatabase()?.PhoneNumberDao()?.deletePhoneNumber(item) }
        Glide.with(holder.itemView).load(item.photo).into(holder.photo)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}