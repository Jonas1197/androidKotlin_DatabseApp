package com.example.databasefun.domain.usecases

import com.example.databasefun.cache.CacheUserData
import com.example.databasefun.cache.UserDataDatabase
import com.example.databasefun.data.UserDataRepository

class InsertUserDataUseCase(
    database: UserDataDatabase
) {

    private val repository = UserDataRepository(
        userDataDao =  database.userDataDao()
    )

    operator fun invoke(userData: CacheUserData) {
        repository.insertUserData(userData)
    }

}