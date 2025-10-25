package com.example.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
//import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
//import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.Wish
import kotlinx.coroutines.launch

@Composable
fun AddEditDetialView(id: Long, viewModel: WishViewModel, navController: NavController ){

    val snackmessage = remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()


    val scaffoldState = rememberScaffoldState()

    Scaffold (  topBar = {
        AppBarView(
            onBackNavClicked = {
                navController.navigateUp()
            },
            title = if (id != 0L) stringResource(id = R.string.Update_Wish) else stringResource(
                id = R.string.Add_Wish
            ))
    }, scaffoldState = scaffoldState){
        Column(modifier = Modifier.padding(it).wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Spacer(Modifier.height(10.dp))
            WishTextField(label = "Title", value = viewModel.wishTitleState, onvaluechanged = {
                viewModel.onWishTitleChanged(it)
            })
            Spacer(Modifier.height(10.dp))
            WishTextField(label = "Desc", value = viewModel.wishDescState, onvaluechanged = {
                viewModel.onWishDescChanged(it)
            })
            Spacer(Modifier.height(10.dp))
            Button(onClick = {
                if(viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescState.isNotEmpty()){
                    if(id != 0L){
                        //update
                    }
                    else{
                        //add wish
                        viewModel.addWish(Wish(title = viewModel.wishTitleState, description = viewModel.wishDescState))
                        snackmessage.value = "wish has been created"
                    }
                }else{
                    snackmessage.value = "enter fields to create a wish"
                }
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(snackmessage.value)
                    navController.navigateUp()
                }
            }) {
                Text(text = if (id != 0L) stringResource(id = R.string.Update_Wish) else stringResource(
                    id = R.string.Add_Wish))
            }

        }
    }

}


@Composable
fun WishTextField(
    label: String,
    value: String,
    onvaluechanged: (String)-> Unit

){
    OutlinedTextField(value = value, onValueChange = onvaluechanged, label = { Text( text = label, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//        colors = TextFieldDefaults.textFieldColors(textColor = Color.Black, )

        )
}

@Preview
@Composable

fun WishTstFeildprev(){
    WishTextField(label = "text", value = "Text", onvaluechanged = {})
}