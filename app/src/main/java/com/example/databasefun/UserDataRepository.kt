package com.example.databasefun

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class UserDataRepository(
    private val userDataDao: UserDataDao
) {

    val allUserData: LiveData<List<UserData>> = userDataDao.getAllUserData()
    val searchResults = MutableLiveData<List<UserData>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertUserData(newUserData: UserData) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataDao.insertUserData(newUserData)
        }
    }

    fun deleteUserData(serialNumber: String) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataDao.deleteUserData(serialNumber)
        }
    }

    fun findUserDataByFirstName(firstName: String) {
        coroutineScope.launch(Dispatchers.Main) {
            coroutineScope.async(Dispatchers.IO) {
                return@async userDataDao.findUserDataByFirstName(firstName)
            }
        }
    }

    fun findUserDataByLastName(lastName: String) {
        coroutineScope.launch(Dispatchers.Main) {
            coroutineScope.async(Dispatchers.IO) {
                return@async userDataDao.findUserDataByLastName(lastName)
            }
        }
    }

    fun findUserDataByFullAddress(fullAddress: String) {
        coroutineScope.launch(Dispatchers.Main) {
            coroutineScope.async(Dispatchers.IO) {
                return@async userDataDao.findUserDataByFullAddress(fullAddress)
            }
        }
    }

    fun findUserDataBySerialNumber(serialNumber: String) {
        coroutineScope.launch(Dispatchers.Main) {
            coroutineScope.async(Dispatchers.IO) {
                return@async userDataDao.findUserDataBySerialNumber(serialNumber)
            }
        }
    }
}