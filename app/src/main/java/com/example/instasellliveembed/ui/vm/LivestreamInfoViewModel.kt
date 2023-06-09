package com.example.instasellliveembed.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instasellliveembed.data.remote.GetLivestreamInfoBody
import com.example.instasellliveembed.data.remote.models.LivestreamInfoModel
import com.example.instasellliveembed.domain.GetLivestreamInfoUseCase
import com.example.instasellliveembed.util.Constants.Companion.ORIGIN_FQDN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LivestreamInfoViewModel @Inject constructor(

    private val getLivestreamInfoUseCase: GetLivestreamInfoUseCase,

) : ViewModel() {

    private val _livestreamInfo = MutableLiveData<LivestreamInfoModel>()
    val livestreamInfo: LiveData<LivestreamInfoModel> get() = _livestreamInfo


    init {
        getLivestreamInfo()
    }

    private fun getLivestreamInfo() {
        viewModelScope.launch {
            try {
                val livestreamInfo = getLivestreamInfoUseCase(GetLivestreamInfoBody(
                    originFqdn = ORIGIN_FQDN
                ))
                _livestreamInfo.value = livestreamInfo
            } catch (_: Exception) {}
        }
    }

}