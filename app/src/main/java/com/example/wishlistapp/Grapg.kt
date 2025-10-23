package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepo

object Graph {
    lateinit var database: WishDatabase

    val wishRepo by lazy {
        WishRepo(wishDao = database.wishDao())
    }


    fun provide(context: Context){
        database = Room.databaseBuilder(context = context, WishDatabase::class.java, "wishlistdb").build()
    }
}