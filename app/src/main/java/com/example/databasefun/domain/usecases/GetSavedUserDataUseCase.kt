package com.example.databasefun.domain.usecases

import com.example.databasefun.cache.CacheUserData
import com.example.databasefun.cache.UserDataDatabase
import com.example.databasefun.data.UserDataRepository
import kotlinx.coroutines.flow.Flow

class GetSavedUserDataUseCase(
    database: UserDataDatabase
) {

    private val repository = UserDataRepository(
        database.userDataDao()
    )

    operator fun invoke(): Flow<List<CacheUserData>> {
        return repository.getSavedUserData()
    }

}