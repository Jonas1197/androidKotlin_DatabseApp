package com.example.databasefun.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.databasefun.R

const val title = "Welcome to DOS Systems"
const val welcomeScreen_Description = "Use this app to register your DOS Operating System License.\nShould there be a problem you can send us a letter to:"
const val welcomeScreen_letterAddress = "California,\n1st High street Av.\nUnited States."

val regular = FontFamily(
    Font(R.font.roboto_mono_regular)
)

val medium = FontFamily(
    Font(R.font.roboto_mono_medium)
)

val bold = FontFamily(
    Font(R.font.roboto_mono_bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

