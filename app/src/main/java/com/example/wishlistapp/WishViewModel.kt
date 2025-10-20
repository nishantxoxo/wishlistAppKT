package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepo: WishRepo) : ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescState by mutableStateOf("")


    fun onWishTitleChanged(newString : String){
        wishTitleState = newString
    }

    fun onWishDescChanged(newString : String){
        wishDescState = newString
    }

    lateinit var getaAllWishes: Flow<List<Wish>>
    init {
        viewModelScope.launch {
            getaAllWishes = wishRepo.getWish()
        }
    }


    fun addWish(wish: Wish){
        viewModelScope.launch {
            wishRepo.addWish(wish)
        }
    }
}