package com.example.databasefun.data

import androidx.lifecycle.MutableLiveData
import com.example.databasefun.cache.CacheUserData
import com.example.databasefun.cache.UserDataDao
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class UserDataRepository(
    private val userDataDao: UserDataDao
) {

    val allCacheUserData: Flow<List<CacheUserData>> = userDataDao.getAllUserData()
    val searchResults = MutableLiveData<List<CacheUserData>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertUserData(newCacheUserData: CacheUserData) {
        userDataDao.insertUserData(newCacheUserData)
    }

    fun deleteUserData(serialNumber: String) {
        userDataDao.deleteUserData(serialNumber)
    }

    fun findUserDataByFirstName(firstName: String) {
        userDataDao.findUserDataByFirstName(firstName)
    }

    fun findUserDataByLastName(lastName: String) {
        userDataDao.findUserDataByLastName(lastName)
    }

    fun findUserDataByFullAddress(fullAddress: String) {
        userDataDao.findUserDataByFullAddress(fullAddress)
    }

    fun findUserDataBySerialNumber(serialNumber: String) {
        userDataDao.findUserDataBySerialNumber(serialNumber)
    }
}