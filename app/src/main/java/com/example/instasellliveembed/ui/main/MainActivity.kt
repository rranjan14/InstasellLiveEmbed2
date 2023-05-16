package com.example.instasellliveembed.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.instasellliveembed.ui.nav.SetupNavHost
import com.example.instasellliveembed.ui.theme.InstasellLiveEmbedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            InstasellLiveEmbedTheme() {

                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {

                    val navController = rememberNavController()
                    SetupNavHost(navController = navController, livestreamInfoViewModel = viewModel())

                }

            }

        }

    }

}