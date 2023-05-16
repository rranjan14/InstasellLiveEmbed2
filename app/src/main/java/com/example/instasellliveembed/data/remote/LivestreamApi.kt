package com.example.instasellliveembed.data.remote

import com.example.instasellliveembed.data.remote.models.LivestreamInfoModel
import com.example.instasellliveembed.util.Constants.Companion.GET_LIVESTREAM_INFO_ENDPOINT
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LivestreamApi {
    @Headers("Content-Type: application/json")
    @POST(GET_LIVESTREAM_INFO_ENDPOINT)
    suspend fun getLivestreamInfo(@Body body:GetLivestreamInfoBody):Response<LivestreamInfoModel>
}

data class GetLivestreamInfoBody(
    val originFqdn:String,
)