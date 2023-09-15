package com.apodaca.testing.part7.data

import com.apodaca.testing.part7.domain.Profile
import com.apodaca.testing.part7.domain.UserRepository
import com.apodaca.testing.util.profile

class UserRepositoryFake: UserRepository {

    var profileToReturn = profile()
    var errorToReturn: Exception? = null

    override suspend fun getProfile(userId: String): Result<Profile> {
        return if(errorToReturn != null) {
            Result.failure(errorToReturn!!)
        } else Result.success(profileToReturn)
    }
}