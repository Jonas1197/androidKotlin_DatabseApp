package com.example.databasefun

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDataDao {

    @Insert
    fun insertUserData(userData: UserData)

    @Query("DELETE FROM saved_data WHERE serial_number = :serialNumber")
    fun deleteUserData(serialNumber: String)

    @Query("SELECT * FROM saved_data WHERE first_name = :firstName")
    fun findUserDataByFirstName(firstName: String): List<UserData>

    @Query("SELECT * FROM saved_data WHERE last_name = :lastName")
    fun findUserDataByLastName(lastName: String): List<UserData>

    @Query("SELECT * FROM saved_data WHERE full_address = :fullAddress")
    fun findUserDataByFullAddress(fullAddress: String): List<UserData>

    @Query("SELECT * FROM saved_data WHERE serial_number = :serialNumber")
    fun findUserDataBySerialNumber(serialNumber: String): List<UserData>

    @Query("SELECT * FROM saved_data")
    fun getAllUserData(): LiveData<List<UserData>>

}