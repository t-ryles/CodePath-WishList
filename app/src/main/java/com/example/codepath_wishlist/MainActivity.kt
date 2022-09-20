package com.example.codepath_wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Getting recycler view
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = WishListAdapter(
            listOf(
                WishListModel(itemNameModel = "Table", itemPriceModel = "59.99", itemURLModel = "www.tables.com"),
                WishListModel(itemNameModel = "mug", itemPriceModel = "9.99", itemURLModel = "www.mugs.com"),
                WishListModel(itemNameModel = "shirt", itemPriceModel = "39.99", itemURLModel = "www.shirt.com")))

        recyclerView.layoutManager = LinearLayoutManager(this)
        //Button used to generate new card in RecyclerView with item info
        //Getting button and setting click event
        findViewById<Button>(R.id.button).setOnClickListener {
            //
            addCard()

            }
        }

    fun addCard() {
        val itemViewInput = findViewById<TextView>(R.id.itemName).text.toString()
        val priceViewInput = findViewById<TextView>(R.id.itemPrice).text.toString()
        val uRLViewInput = findViewById<TextView>(R.id.itemURL).text.toString()

        val newItem = WishListModel(itemViewInput, priceViewInput, uRLViewInput)

        val adapter = recyclerView.adapter as WishListAdapter
        adapter.upDateWishList(adapter.wishListModel + newItem)


    }
}