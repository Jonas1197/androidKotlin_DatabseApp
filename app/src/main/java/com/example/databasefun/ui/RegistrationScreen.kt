package com.example.databasefun.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.databasefun.R
import com.example.databasefun.presentation.RegistrationViewModel
import com.example.databasefun.ui.theme.*

@Preview
@Composable
fun RegistrationScreen() {
    val focusManager = LocalFocusManager.current

    val viewModel = RegistrationViewModel()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {

        Column {
            if(viewModel.state.showsAlerts) {
                AlertDialog(
                    title = {
                        Text(text = "Please fill all the details!")
                    },
                    buttons = {
                        Button(
                            onClick = { viewModel.updateShowsAlert(false) }
                        ) {
                            Text(text = "LOL")
                        }
                    },

                    onDismissRequest = {
                        viewModel.updateShowsAlert(false)
                    }
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp),
                    painter = painterResource(R.drawable.dos_logo),
                    contentDescription = null
                )

                Text(
                    "Systems registration",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    color = Color.White,
                    fontFamily = bold,
                    fontSize = 18.sp
                )
            }

            Text(
                "Enter your details below to activate your copy of DOS Operating System.",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.White,
                fontFamily = medium,
                fontSize = 16.sp
            )

            Column {
                CustomTextField(
                    hint = "First name",
                    valueTyped = {
                        viewModel.updateFirstName(it)
                    }
                )

                CustomTextField(
                    hint = "Last name",
                    valueTyped = {
                        viewModel.updateLastName(it)
                    }
                )

                CustomTextField(
                    hint = "Full address",
                    valueTyped = {
                        viewModel.updateFullAddress(it)
                    }
                )

                CustomTextField(
                    hint = "DOS System serial number",
                    valueTyped = {
                        viewModel.updateSerialNumber(it)
                    }
                )

                Spacer(
                    modifier = Modifier
                        .weight(0.1f)
                )

                Text(
                    viewModel.registrationDetails(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    fontFamily = regular,
                    color = Color.White,
                )

                CustomButton(
                    text = "Register copy",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    onClick = {
                        viewModel.updateShowsAlert()
                    }
                )
            }
        }
    }
}