package com.example.instasellliveembed.ui.screens

import android.annotation.SuppressLint
import android.net.Uri
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.instasellliveembed.util.Constants.Companion.WEBVIEW_URL


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerWebViewScreen(livestreamId:String, navController: NavController) {
    val url = Uri
        .Builder()
        .scheme("https")
        .authority(WEBVIEW_URL)
        .path("/")
        .appendQueryParameter("isl-livestream-id",livestreamId)
        .build()

    Scaffold(
        content = {
            AndroidView(
                modifier = Modifier.fillMaxSize().padding(top = it.calculateTopPadding()),
                factory = { context ->
                    WebView(context).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        settings.javaScriptEnabled = true
                        settings.domStorageEnabled=true
                        webViewClient = WebViewClient()
                        loadUrl(url.toString())
                        addJavascriptInterface(WebViewInterface(context = context),"Android")
                    }
                }
            )
        }
    )
}
