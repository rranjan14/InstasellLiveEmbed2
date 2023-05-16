package com.example.instasellliveembed.domain

import com.example.instasellliveembed.data.remote.GetLivestreamInfoBody
import com.example.instasellliveembed.data.remote.models.LivestreamInfoModel
import com.example.instasellliveembed.repo.LivestreamInfoRepository
import javax.inject.Inject

class GetLivestreamInfoUseCase @Inject constructor(private val livestreamInfoRepository: LivestreamInfoRepository) {
    suspend operator fun invoke(requestBody:GetLivestreamInfoBody): LivestreamInfoModel {
        return livestreamInfoRepository.getLivestreamInfo(requestBody)
    }
}