package com.example.techtrekkerbitnbuild.screenpages

import android.os.Build
import android.util.Patterns
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.techtrekkerbitnbuild.components.DetailsTextField
import com.example.techtrekkerbitnbuild.components.MyButton
import com.example.techtrekkerbitnbuild.components.MyCheckBox
import com.example.techtrekkerbitnbuild.components.MySpacer
import com.example.techtrekkerbitnbuild.components.PasswordTextField
import com.example.techtrekkerbitnbuild.components.TitleText
import com.example.techtrekkerbitnbuild.curUser
import com.example.techtrekkerbitnbuild.databaseFiles.UserDataDao
import com.example.techtrekkerbitnbuild.screenrouter.Screen
import com.example.techtrekkerbitnbuild.screenrouter.ScreenRouter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import java.time.Duration


var curUserId by mutableStateOf(0L)


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    userDao: UserDataDao
) {


    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var userFound by remember {
        mutableStateOf(false)
    }

    var userStatus by remember {
        mutableStateOf(UserStatus.LoggedOut)
    }
    var check1 by remember {
        mutableStateOf(false)
    }
    var check2 by remember {
        mutableStateOf(false)
    }


    LaunchedEffect(userStatus) {
        if (userStatus == UserStatus.LogError) {
            delay(Duration.ofSeconds(2)) // Wait for 2 seconds
            userStatus = UserStatus.LoggedOut

        }
    }
    val isLoginEnabled by remember( email, password,check1,check2) {
        mutableStateOf(
                    email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                    password.isNotBlank() && check1 && check2
        )
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color.White),
//        tonalElevation = 2.dp,
        shadowElevation = 8.dp,
    ) {


        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {


            if (userStatus == UserStatus.LogError) {

                TitleText(pageText = "Login Error", greet = false, color = Color.Red)
            }
            else TitleText(pageText = "Welcome Back")
            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {


                DetailsTextField(labelVal = "Email", onValueChange = { email = it })
                MySpacer(h = 12)
                PasswordTextField(onValueChange = { password = it })

            }
            Column(

                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                check1 = MyCheckBox("By continuing you accept our Privacy Policy and Terms of Use ")
                check2 = MyCheckBox("Remember me")

            }
            MyButton(
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        val user = userDao.getAllUsers()

                        // Perform further operations with insertedUser here

                        user.forEach { item ->
                            if (item.email == email && item.password == password) {
                                userFound = true
                                curUserId = item.id

                            }


                        }
                        if (userFound) {
                            println("Login Success")
                            userStatus = UserStatus.LoggedIn
                            curUser = userDao.getUserById(curUserId);
                            ScreenRouter.navigateTo(Screen.ProfileScreen)
                        } else {
                            println("Login Fail")
                            userStatus = UserStatus.LogError
                        }


                    }


                },
                btnVal = "Login",

                enabled = isLoginEnabled
                )

            MySpacer(h = 12)
            MyButton(
                onClick = {
                    ScreenRouter.navigateTo(Screen.HomeScreen)
                },
                btnVal = "Back",
                enabled = true
            )

        }
    }


}

enum class UserStatus {
    LoggedIn, LoggedOut, LogError
}


