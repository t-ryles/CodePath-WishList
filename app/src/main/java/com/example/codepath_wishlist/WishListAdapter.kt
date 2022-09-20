package com.example.codepath_wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter(var wishListModel: List<WishListModel>): RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO: Create member variables for any view that will be set

        val itemName: TextView
        val itemPrice: TextView
        val itemURL: TextView

        init {
            // TODO: Store each of the layout's views into
            itemName = itemView.findViewById(R.id.itemName)
            itemPrice = itemView.findViewById(R.id.itemPrice)
            itemURL = itemView.findViewById(R.id.itemURL)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_list_row, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishListModel = wishListModel[position]
        // Set item views based on views and data model
        holder.itemName.text = wishListModel.itemNameModel
        holder.itemPrice.text = wishListModel.itemPriceModel
        holder.itemURL.text = wishListModel.itemURLModel
    }

    fun upDateWishList(newWishListModel: List<WishListModel>) {
        wishListModel = newWishListModel
    }

    override fun getItemCount(): Int {
        return wishListModel.size
    }
}