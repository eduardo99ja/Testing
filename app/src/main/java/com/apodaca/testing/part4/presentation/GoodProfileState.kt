package com.apodaca.testing.part4.presentation

data class GoodProfileState(
    val profileId: Long = 0,
    val username: String = "",
    val bio: String = "",
    val isLoading: Boolean = false,
    val infoMessage: UiText? = null
)