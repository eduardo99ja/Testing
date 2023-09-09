package com.apodaca.testing.part4.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.apodaca.testing.R
import com.apodaca.testing.part4.domain.AnalyticsLogger
import com.apodaca.testing.part4.domain.LogParam

class GoodProfileViewModel(
    private val analytics: AnalyticsLogger
) : ViewModel() {

    var state by mutableStateOf(GoodProfileState())
        private set

    fun saveProfile() {
        analytics.logEvent(
            "save_profile",
            LogParam("profile_id", state.profileId),
            LogParam("username", state.username),
        )
        state = state.copy(
            infoMessage = UiText.StringResource(R.string.successfully_saved_profile)
        )
    }
}