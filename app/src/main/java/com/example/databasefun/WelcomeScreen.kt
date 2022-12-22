package com.example.databasefun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.databasefun.ui.theme.*


@Composable
fun WelcomeScreen(
    navController: NavController
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Blue)
    ) {
        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .aspectRatio(3f),
                    painter = painterResource(R.drawable.dos_logo),
                    contentDescription = null
                )

                Text(
                    title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    fontFamily = bold,
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    color = Color.White
                )

                Text(
                    welcomeScreen_Description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    color = Color.White,
                    fontFamily = regular,
                    fontSize = 16.sp
                )

                Spacer(
                    modifier = Modifier
                        .weight(0.2f)
                )

                Text(
                    welcomeScreen_letterAddress,
                    fontFamily = regular,
                    color = Color.White
                )
                
                Spacer(
                    modifier = Modifier
                        .weight(2f)
                )

                CustomButton(
                    text = "Continue to registration",
                    onClick = {
                        navController.navigate(Screen.RegistrationScreen.route)
                    }
                )
                
            }
        }
    }
}