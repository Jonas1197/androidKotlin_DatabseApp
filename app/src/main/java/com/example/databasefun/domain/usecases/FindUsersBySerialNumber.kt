package com.example.databasefun.domain.usecases

import com.example.databasefun.cache.CacheUserData
import com.example.databasefun.cache.UserDataDatabase
import com.example.databasefun.data.UserDataRepository
import kotlinx.coroutines.flow.Flow


class FindUsersBySerialNumber(
    database: UserDataDatabase
) {

    private val repository = UserDataRepository(
        userDataDao = database.userDataDao()
    )

    operator fun invoke(serialNumber: String): Flow<List<CacheUserData>> {
        return repository.findUsersDataBySerialNumber(serialNumber)
    }

}