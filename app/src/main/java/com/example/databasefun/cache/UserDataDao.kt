package com.example.databasefun.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDataDao {

    @Insert
    fun insertUserData(cacheUserData: CacheUserData)

    @Query("DELETE FROM saved_data WHERE serial_number = :serialNumber")
    fun deleteUserData(serialNumber: String)

    @Query("SELECT * FROM saved_data WHERE first_name = :firstName")
    fun findUserDataByFirstName(firstName: String): Flow<List<CacheUserData>>

    @Query("SELECT * FROM saved_data WHERE last_name = :lastName")
    fun findUserDataByLastName(lastName: String): Flow<List<CacheUserData>>

    @Query("SELECT * FROM saved_data WHERE full_address = :fullAddress")
    fun findUserDataByFullAddress(fullAddress: String): Flow<List<CacheUserData>>

    @Query("SELECT * FROM saved_data WHERE serial_number = :serialNumber")
    fun findUserDataBySerialNumber(serialNumber: String): Flow<List<CacheUserData>>

    @Query("SELECT * FROM saved_data")
    fun getAllUserData(): Flow<List<CacheUserData>>

}