package com.example.instasellliveembed.util

class Constants {

    companion object {

        const val BASE_URL = "https://chat.instasell.io/capi.v1.ChatApiService/"
        const val GET_LIVESTREAM_INFO_ENDPOINT = "GetLivestreamInfo"
        const val WEBVIEW_URL = "instasell-live-beige.vercel.app"
        const val ORIGIN_FQDN = "<your-registered-fqdn>" // this could be one of the domains you have have registered with Instasell to display the livestream feed on
    }

    object Screens {
        const val INSTASELL_LIVESTREAM_LIST = "instasell_livestream_list"
        const val INSTASELL_VIDEO_PLAYER_SCREEN = "instasell_video_player_screen"
    }

}