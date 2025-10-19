package com.example.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepo(private val wishDao: WishDao) {
    suspend fun addWish(wish: Wish){
        wishDao.addWish(wish)
    }

    fun getWish(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishByID(id: Long) : Flow<Wish> = wishDao.getWishById(id)

    suspend fun updateWish(wish: Wish){
        wishDao.updateWish(wish)
    }

    suspend fun deleteWish(wish: Wish){
        wishDao.deleteWish(wish)
    }
}