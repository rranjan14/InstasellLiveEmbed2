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