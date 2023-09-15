package com.apodaca.testing.part7.domain

import com.apodaca.testing.part7.domain.Profile

interface UserRepository {
    suspend fun getProfile(userId: String): Result<Profile>
}