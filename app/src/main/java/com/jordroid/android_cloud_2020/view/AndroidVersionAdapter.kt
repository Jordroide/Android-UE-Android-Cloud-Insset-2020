package com.jordroid.android_cloud_2020.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jordroid.android_cloud_2020.R
import com.jordroid.android_cloud_2020.model.ObjectDataSample

class AndroidVersionAdapter(private val context : Context) : RecyclerView.Adapter<AndroidVersionAdapter.AndroidVersionViewHolder>() {

    /**
     * Attribute
     */

    // Create list of data we want to display in list as var of class
    private val mAndroidListVersion = ArrayList<ObjectDataSample>()
    // Needed to get the item_layout
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    // Callback instance
    private val mCallback = context as OnClickCallback

    /**
     * Manage lifecycle
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidVersionViewHolder {
        // This line perform the matching with our ViewHolder and the item from layout
        return AndroidVersionViewHolder(mInflater.inflate(R.layout.item_custom_recycler, parent, false))
    }

    override fun getItemCount(): Int  = mAndroidListVersion.size

    override fun onBindViewHolder(holder: AndroidVersionViewHolder, position: Int) {
        // onBindViewHolder is called for each item we want to display so we need to get each object
        val currentItem = mAndroidListVersion[position]
        // Set the value of our POJO for each item
        holder.itemRecyclerViewVersionName.text = currentItem.versionName
        holder.itemRecyclerViewVersionCode.text = currentItem.versionCode.toString()
    }

    /**
     * Public method (Called from activity)
     */

    fun rebuild(androidListVersion : ArrayList<ObjectDataSample>) {
        // This is the simplest way to update the list
        mAndroidListVersion.clear()
        mAndroidListVersion.addAll(androidListVersion)
        // Needed to said to recycler view we have new data
        this.notifyDataSetChanged()
    }

    /**
     * Internal class
     */

    inner class AndroidVersionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemRecyclerViewVersionName: TextView = itemView.findViewById(R.id.itemRecyclerViewVersionName)
        val itemRecyclerViewVersionCode: TextView = itemView.findViewById(R.id.itemRecyclerViewVersionCode)

        init {
            this.itemView.setOnClickListener { itemClicked() }
        }

        private fun itemClicked() {
            mCallback.onItemClick(
                this@AndroidVersionAdapter.mAndroidListVersion[adapterPosition])
        }
    }
}
