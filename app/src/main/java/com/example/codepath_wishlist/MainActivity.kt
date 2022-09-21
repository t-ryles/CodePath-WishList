package com.example.codepath_wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codepath_wishlist.R.id.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Getting recycler view
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = WishListAdapter(
            listOf(
                WishListModel(itemNameModel = "", itemPriceModel = "", itemURLModel = "")))

        recyclerView.layoutManager = LinearLayoutManager(this)
        //Button used to generate new card in RecyclerView with item info
        //Getting button and setting click event
        findViewById<Button>(R.id.button).setOnClickListener {
            //
            addCard()
            }
        }

    private fun addCard() {
        val nameInputText = findViewById<TextView>(nameInput).text.toString()
        val priceInputText = findViewById<TextView>(priceInput).text.toString()
        val urlInputText = findViewById<TextView>(URLInput).text.toString()

        val newItem = WishListModel(nameInputText, priceInputText, urlInputText)

        val adapter = recyclerView.adapter as WishListAdapter
        adapter.upDateWishList(adapter.wishListModel + newItem)
    }
}