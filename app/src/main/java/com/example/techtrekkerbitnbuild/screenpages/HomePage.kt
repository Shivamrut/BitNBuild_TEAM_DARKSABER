package com.example.techtrekkerbitnbuild.screenpages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.techtrekkerbitnbuild.components.MyButton
import com.example.techtrekkerbitnbuild.components.MySpacer
import com.example.techtrekkerbitnbuild.components.TitleText
import com.example.techtrekkerbitnbuild.components.color
import com.example.techtrekkerbitnbuild.screenrouter.Screen
import com.example.techtrekkerbitnbuild.screenrouter.ScreenRouter

@Composable
fun Home(modifier: Modifier = Modifier) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color.White),
//        tonalElevation = 2.dp,
        shadowElevation = 2.dp,
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier.height(400.dp).width(300.dp).border(
                    BorderStroke(1.dp, "#D3D3D3".color)
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                TitleText(pageText = "Please Login or SignUp", 24, false)

                Column(

                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    MySpacer(h = 40)
                    Text(
                        text = "Don't have an account?\nSign up now for free", fontSize = 20.sp,
                        modifier
                        = Modifier
                            .padding(8.dp),
                        textAlign = TextAlign.Center,


                        )

                    MyButton(
                        onClick = {
                            ScreenRouter.navigateTo(Screen.SignUpScreen)
                        },
                        btnVal = "Sign Up",
                        enabled = true
                    )
                    MySpacer(h = 20)
                    Text(
                        text = "Already Registered?\nLogin here", fontSize = 20.sp,
                        modifier
                        = Modifier
                            .padding(8.dp),
                        textAlign = TextAlign.Center

                    )
                    MyButton(
                        onClick = {
                            ScreenRouter.navigateTo(Screen.LoginScreen)
                        },
                        btnVal = "Login",
                        enabled = true
                    )

                }


            }
        }


    }

}

@Preview
    (
    showBackground = true,
    showSystemUi = true

)
@Composable
fun Preview8() {
    Home()
}