package com.example.instasellliveembed.repo

import com.example.instasellliveembed.data.remote.GetLivestreamInfoBody
import com.example.instasellliveembed.data.remote.LivestreamService
import com.example.instasellliveembed.data.remote.models.LivestreamInfoModel
import javax.inject.Inject

class LivestreamInfoRepository @Inject constructor(private val livestreamService: LivestreamService) {

    suspend fun getLivestreamInfo(requestBody: GetLivestreamInfoBody): LivestreamInfoModel {

        return livestreamService.getLivestreamInfo(requestBody)

    }
}