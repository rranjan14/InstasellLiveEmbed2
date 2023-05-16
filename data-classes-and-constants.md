---
description: >-
  Contains data classes for the resources and some important constant value
  which needs to be added as is.
---

# Data classes and constants

&#x20;  Livestream Model (app/src/main/com/example/instasellliveembed/data/remote/modelsLivestreamModel.kt)

```kotlin
// models a single livestream
package com.example.instasellliveembed.data.remote.models

data class LivestreamModel(
    val id:String,
    val startAt:Long,
    val title:String,
    val live:Boolean,
    val description:String,
    val viewersCount:Long,
    val thumbnailUrl:String?="",
)
```

Livestream Info Model (app/src/main/com/example/instasellliveembed/data/remote/modelsLivestreamInfoModel.kt)

```kotlin
package com.example.instasellliveembed.data.remote.models

data class LivestreamInfoModel (
    val viewerToken:String,
    val businessId:String,
    val streamPageUrl:String,
    val embedIdleView:EmbedIdleViewModel?=null,
    val customerCount:Long,
    val pastLivestreams:List<LivestreamModel>?=null,
    val currentLivestream:LivestreamModel?=null,
    val nextLivestream: LivestreamModel?=null
)

data class EmbedIdleViewModel (
    val hidden:Boolean,
    val showFab:Boolean,
    val showBanner:Boolean,
    val showPopup:Boolean,
    val showPastStreams:Boolean,
    val popupOpenTime:Int
)
```

Constants (\`app/src/main/com/example/instasellliveembed/util/Constants.kt\`)

```kotlin
package com.example.instasellliveembed.util

class Constants {

    companion object {

        const val BASE_URL = "https://chat.instasell.io/capi.v1.ChatApiService/"
        const val GET_LIVESTREAM_INFO_ENDPOINT = "GetLivestreamInfo"
        const val WEBVIEW_URL = "instasell-live-beige.vercel.app"
        // add your value in place of <your-registered-fqdn>
        const val ORIGIN_FQDN = "<your-registered-fqdn>" // this could be one of the domains you have have registered with Instasell to display the livestream feed on
    }

    object Screens {
        const val INSTASELL_LIVESTREAM_LIST = "instasell_livestream_list"
        const val INSTASELL_VIDEO_PLAYER_SCREEN = "instasell_video_player_screen"
    }

}
```

All these data models and constants defined are very importanf for the application to work properly. Make sure you add these to you app and replace the appropriate values
