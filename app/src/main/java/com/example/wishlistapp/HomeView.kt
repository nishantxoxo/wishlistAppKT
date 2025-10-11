package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wishlistapp.data.DummyWish
import com.example.wishlistapp.data.Wish

@Composable
fun HomeView(){
    val context =  LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(all = 20.dp) ,
                onClick = {
                    Toast.makeText(context, "FAB clicked", Toast.LENGTH_LONG ).show()
                },
                contentColor = Color.Blue,
                backgroundColor = Color.White
                ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },

        topBar = { AppBarView(title = "aaaa", {
        Toast.makeText(context, "button clicked", Toast.LENGTH_LONG ).show()
    }) }) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)) {
            items(DummyWish.wishList){
                it -> WishItem(wish= it) { }
            }
        }
    }
}


@Composable
fun WishItem(wish: Wish, onClick: ()-> Unit){
    Card (modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 8.dp, end = 8.dp).clickable( indication = LocalIndication.current,
        interactionSource = remember { MutableInteractionSource() }) {

        onClick()
    }, elevation = 10.dp, backgroundColor = Color.White){
            Column (modifier = Modifier.padding(10.dp)){
                Text(text = wish.title, fontWeight = FontWeight.Bold)
                Text(text = wish.description, )

            }
    }
}