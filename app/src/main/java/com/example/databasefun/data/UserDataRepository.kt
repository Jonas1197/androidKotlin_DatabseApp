package com.example.databasefun.data

import androidx.lifecycle.MutableLiveData
import com.example.databasefun.cache.CacheUserData
import com.example.databasefun.cache.UserDataDao
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class UserDataRepository(
    private val userDataDao: UserDataDao
) {

    val searchResults = MutableLiveData<List<CacheUserData>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertUserData(newCacheUserData: CacheUserData) {
        userDataDao.insertUserData(newCacheUserData)
    }

    fun deleteUserData(serialNumber: String) {
        userDataDao.deleteUserData(serialNumber)
    }

    fun findUsersDataByFirstName(firstName: String): Flow<List<CacheUserData>> {
        return userDataDao.findUserDataByFirstName(firstName)
    }

    fun findUsersDataByLastName(lastName: String): Flow<List<CacheUserData>> {
        return userDataDao.findUserDataByLastName(lastName)
    }

    fun findUsersDataByFullAddress(fullAddress: String): Flow<List<CacheUserData>> {
        return userDataDao.findUserDataByFullAddress(fullAddress)
    }

    fun findUsersDataBySerialNumber(serialNumber: String): Flow<List<CacheUserData>> {
        return userDataDao.findUserDataBySerialNumber(serialNumber)
    }

    fun getSavedUserData(): Flow<List<CacheUserData>> {
        return userDataDao.getSavedUserData()
    }
}