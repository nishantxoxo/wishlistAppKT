package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeView(){
    val context =  LocalContext.current

    Scaffold(topBar = { AppBarView(title = "FUCK", {
        Toast.makeText(context, "button clicked", Toast.LENGTH_LONG ).show()
    }) }) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)) {  }
    }
}