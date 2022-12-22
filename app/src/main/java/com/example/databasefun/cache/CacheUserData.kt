package com.example.databasefun.cache

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_data")
class CacheUserData {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "first_name")
    var firstName = ""

    @ColumnInfo(name = "last_name")
    var lastName = ""

    @ColumnInfo(name = "full_address")
    var fullAddress = ""

    @ColumnInfo(name = "serial_number")
    var serialNumber = ""

    constructor() {}

    constructor(
        firstName: String,
        lastName: String,
        fullAddress: String,
        serialNumber: String
    ) {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.fullAddress = fullAddress
        this.serialNumber = serialNumber
    }

}