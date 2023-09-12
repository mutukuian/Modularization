package com.blogapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.domain.model.Ships


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    if (state.isLoading){
        Box (modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (state.error.isNotBlank()){
        Box (modifier = Modifier.fillMaxSize()){
            Text(text = state.error.toString(), modifier = Modifier.align(Alignment.Center))
        }
    }


    LazyColumn{

            items(state.ships){
                    ship ->
                PostItem(it = ship)
            }
        }

}


@Composable
fun PostItem(it: Ships) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberImagePainter(it.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

    }
}
