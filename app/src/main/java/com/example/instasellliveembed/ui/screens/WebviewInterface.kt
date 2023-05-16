package com.example.instasellliveembed.ui.screens

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
import android.widget.Toast
import org.json.JSONObject
import java.util.*

/** Instantiate the interface and set the context  */
class WebViewInterface(private val context: Context) {

    /** Show a toast from the web page  */
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(context, toast, Toast.LENGTH_LONG).show()
    }

    @JavascriptInterface
    fun getCurrentCurrency(): String {
        return "USD";
    }

    @JavascriptInterface
    fun getCurrentLocale(): String {
        return "en-US";
    }

    @JavascriptInterface
    fun addToCart(json: String) { // it is a stringified json {variantId:string,via:string,handle:string}
        try {
            JSONObject(json).let {
                //parsed cart object

            }
        } catch (e: Exception) {
            Toast.makeText(context, "Could not add to cart", Toast.LENGTH_LONG).show()
        }
    }

    @JavascriptInterface
    fun checkout(json: String) { // it is a stringified json object
        try {
            JSONObject(json).let {
                //parse checkout data if there's any
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Could not complete checkout", Toast.LENGTH_LONG).show()
        }
    }
}