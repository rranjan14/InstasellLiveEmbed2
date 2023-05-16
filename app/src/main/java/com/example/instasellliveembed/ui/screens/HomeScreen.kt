package com.example.instasellliveembed.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.instasellliveembed.data.remote.models.LivestreamModel
import com.example.instasellliveembed.ui.nav.Screens
import com.example.instasellliveembed.ui.vm.LivestreamInfoViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(livestreamInfoViewModel: LivestreamInfoViewModel, navController: NavController) {
    val livestreamInfo = livestreamInfoViewModel.livestreamInfo.observeAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Livestreams", fontWeight = FontWeight.Bold)
                }
            )
        },
        content = { innerPadding ->
            if (livestreamInfo != null) {
                val finalItems = mutableListOf<LivestreamModel>()
                if (livestreamInfo.pastLivestreams != null) {
                    finalItems.addAll(livestreamInfo.pastLivestreams)
                }
                if (livestreamInfo.nextLivestream != null) {
                    finalItems.add(0, livestreamInfo.nextLivestream)
                }
                if (livestreamInfo.currentLivestream != null) {
                    finalItems.add(0, livestreamInfo.currentLivestream)
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                        .padding(top = innerPadding.calculateTopPadding()),
                    contentPadding = PaddingValues(top = 8.dp)
                ) {

                    items(finalItems) { item ->
                        LivestreamCard(item, navController)
                    }
                }
            }

        }
    )
}

@Composable
fun LivestreamCard(livestream: LivestreamModel, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
            navController.navigate(Screens.VideoPlayer.createRoute(livestream.id))
        },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column {

            Image(
                painter = rememberImagePainter(livestream.thumbnailUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
                ) {

                Text(text = livestream.title?:"", fontWeight = FontWeight.Bold)
                Text(text = livestream.description?:"", maxLines = 2, overflow = TextOverflow.Ellipsis)

            }

        }

    }

}