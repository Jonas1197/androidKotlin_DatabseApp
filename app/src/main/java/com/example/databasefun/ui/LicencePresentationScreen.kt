package com.example.databasefun.ui

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import com.example.databasefun.R
import androidx.navigation.NavController
import com.example.databasefun.domain.OnLifecycleEvent
import com.example.databasefun.presentation.LicencePresentationViewModel
import com.example.databasefun.ui.theme.bold
import com.example.databasefun.ui.theme.medium
import com.example.databasefun.ui.theme.regular

@Composable
fun LicencePresentationScreen(
    application: Application,
    viewModel: LicencePresentationViewModel = LicencePresentationViewModel(application),
    navController: NavController
) {

    OnLifecycleEvent { _, event ->
        when(event) {
            Lifecycle.Event.ON_CREATE -> {
                viewModel.fetchUpdatedData()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Column {
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
                "Congratulations! Your DOS Operating System license has been registered and saved in our systems! Enjoy!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.White,
                fontFamily = medium,
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier
                    .weight(0.2f)
            )

            Column {

                Text(
                    viewModel.state.formattedData,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    color = Color.White,
                    fontFamily = regular,
                    fontSize = 16.sp
                )
            }
        }
    }
}