package com.example.databasefun.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.databasefun.ui.theme.regular

@Preview
@Composable
fun CustomTextField(
    hint: String = "Hint example",
    valueTyped: ((String) -> Unit)? = null
) {

    Column(Modifier.padding(16.dp)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        val focusManager = LocalFocusManager.current

        TextField(
            value = textState.value,
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            onValueChange = { textState.value = it },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )

        Text(
            hint,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.7f),
            color = Color.White,
            fontFamily = regular,
            fontSize = 12.sp
        )

        if (valueTyped != null) {
            valueTyped(textState.value.text)
        }
    }

}