package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel : ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescState by mutableStateOf("")


    fun onWishTitleChanged(newString : String){
        wishTitleState = newString
    }

    fun onWishDescChanged(newString : String){
        wishDescState = newString
    }
}