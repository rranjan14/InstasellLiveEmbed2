package com.example.instasellliveembed.data.remote

import android.annotation.SuppressLint
import android.util.Log
import com.example.instasellliveembed.data.remote.models.LivestreamInfoModel
import com.example.instasellliveembed.data.remote.models.LivestreamModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class ApiException(val statusCode: Int, override val message: String?) : Exception(message)

class NetworkException(message: String?) : Exception(message)


class LivestreamService @Inject constructor(private val livestreamApi: LivestreamApi) {
    @SuppressLint("SuspiciousIndentation")
    suspend fun getLivestreamInfo(requestBody:GetLivestreamInfoBody): LivestreamInfoModel {
        return withContext(Dispatchers.IO) {
            try {
            val response = livestreamApi.getLivestreamInfo(requestBody)
                if(response.isSuccessful) {
                    val responseBody = response.body()
                    Log.d("response body => ",responseBody.toString())

                    val updatedCurrentLivestream = responseBody?.currentLivestream
                    val updatedPastLivestreams = responseBody?.pastLivestreams
                    val updatedNextLivestream = responseBody?.nextLivestream

                    LivestreamInfoModel(
                        viewerToken = responseBody?.viewerToken.orEmpty(),
                        streamPageUrl = responseBody?.streamPageUrl.orEmpty(),
                        embedIdleView = responseBody?.embedIdleView,
                        customerCount = responseBody?.customerCount ?: 0,
                        pastLivestreams = updatedPastLivestreams.orEmpty(),
                        nextLivestream = updatedNextLivestream,
                        businessId = responseBody?.businessId.orEmpty(),
                        currentLivestream = updatedCurrentLivestream
                    )
                }else{
                    throw ApiException(response.code(), response.message())
                }
            } catch (e: IOException) {
                // Handle network errors (e.g. connection timeout, no internet)
                throw NetworkException(e.message ?: "Unknown network error")
            }
        }
    }

}