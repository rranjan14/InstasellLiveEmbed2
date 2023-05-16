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