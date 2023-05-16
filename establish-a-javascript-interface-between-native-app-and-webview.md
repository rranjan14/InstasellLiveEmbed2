---
description: >-
  Contains code to set up a data flow from the native app to the webview and
  vice versa.
---

# Establish a JavaScript interface between native app and Webview

Implement a `WebView Interface` class

```kotlin
package com.example.instasellliveembed.ui.screens

import android.content.Context
import android.webkit.JavascriptInterface
import org.json.JSONObject

/** Instantiate the interface and set the context  */
class WebViewInterface(private val context: Context) {

    @JavascriptInterface
    fun addToCart(json: String) { // it is a stringified json {variantId:string,via:string,handle:string}
        try {
            JSONObject(json).let {
                // parsed cart object
                // fill in this block to implement add to cart in the mobile app
                // the object is 
                // {
                //     variantId:string,
                //     handle:string(product slug),
                //     via:"REELS"|"LIVE"
                //}

            }
        } catch (e: Exception) {
            Toast.makeText(context, "Could not add to cart", Toast.LENGTH_LONG).show()
        }
    }
}
```

Make sure you added the interface to the webview using the **addJavascriptInterface** method when initializing the webview. (While this has already been taken care for you, make sure you double check it. If not added, the data won't flow between the app and webpage).
