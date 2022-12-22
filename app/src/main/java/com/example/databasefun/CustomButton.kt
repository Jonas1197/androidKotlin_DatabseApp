package com.example.databasefun

import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.databasefun.ui.theme.medium

@Preview
@Composable
fun CustomButton(
    text: String = "Button",
    modifier: Modifier? = null,
    buttonColor: Color = Color.Black,
    tintColor: Color = Color.White,
    onClick: (() -> Unit)? = null
) {
    Button(
        modifier = modifier ?: Modifier,
        onClick = onClick ?: {},
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = buttonColor
        )
    ) {
        Text(
            text,
            fontFamily = medium,
            color = tintColor
        )
    }
}