package com.example.databasefun.presentation

import com.example.databasefun.cache.CacheUserData

data class LicensePresentationState(
    val userData: CacheUserData? = null,
    val formattedData: String = "No data..."
)