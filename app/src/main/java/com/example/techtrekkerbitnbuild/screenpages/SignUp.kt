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
import com.example.techtrekkerbitnbuild.databaseFiles.UserData
import com.example.techtrekkerbitnbuild.databaseFiles.UserDataDao
import com.example.techtrekkerbitnbuild.screenrouter.Screen
import com.example.techtrekkerbitnbuild.screenrouter.ScreenRouter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import java.time.Duration

enum class RegisterStatus {
    Registered, RegisterError, NewUser
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SignUp(
    modifier: Modifier = Modifier,
//    context: Context,
    userDao: UserDataDao
) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userStatus by remember {
        mutableStateOf(RegisterStatus.NewUser)
    }
    var check1 by remember {
        mutableStateOf(false)
    }
    var check2 by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(userStatus) {
        if (userStatus == RegisterStatus.Registered) {
            delay(Duration.ofSeconds(2)) // Wait for 2 seconds
            userStatus = RegisterStatus.NewUser

        }
    }
    val isSignUpEnabled by remember(firstName, lastName, email, password, check1, check2) {
        mutableStateOf(
            firstName.isNotBlank() &&
                    lastName.isNotBlank() &&
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
            verticalArrangement = Arrangement.Center
        ) {
            when (userStatus) {
                RegisterStatus.Registered -> TitleText(pageText = "Account Created", greet = false, color = Color.Green)
                RegisterStatus.NewUser -> TitleText(pageText = "Create an Account")
                RegisterStatus.Registered -> TitleText(pageText = "Sign Up Error", greet = false, color = Color.Red)
                else -> TitleText(pageText = "Create an Account")
            }

            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                DetailsTextField(labelVal = "First Name", onValueChange = {
                    firstName = it
//                    println("Main: $firstName")

                })
                MySpacer(h = 12)
                DetailsTextField(labelVal = "Last Name", onValueChange = { lastName = it })
                MySpacer(h = 12)
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

                println("Checking: $check1 & $check2")

            }

            MyButton(
                onClick = {
                    val user = UserData(firstName = firstName, lastName = lastName, email = email, password = password)
                    CoroutineScope(Dispatchers.IO).launch {


                        val userId = userDao.insertUser(user)
                        val insertedUser = userDao.getUserById(userId)

                        println(insertedUser)
                        println(userDao.getAllUsers())
                        userStatus = RegisterStatus.Registered
//                        userDao.deleteAll()

                    }
                    // Navigate to the next screen or perform other UI-related actions here
                },
                btnVal = "Sign Up",
                enabled = isSignUpEnabled
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

