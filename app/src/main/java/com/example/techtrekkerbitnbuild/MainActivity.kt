package com.example.techtrekkerbitnbuild

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.techtrekkerbitnbuild.databaseFiles.UserData
import com.example.techtrekkerbitnbuild.databaseFiles.UserDataBase
import com.example.techtrekkerbitnbuild.databaseFiles.UserDataDao
import com.example.techtrekkerbitnbuild.screenpages.EditProfile
import com.example.techtrekkerbitnbuild.screenpages.Home
import com.example.techtrekkerbitnbuild.screenpages.LoginPage
import com.example.techtrekkerbitnbuild.screenpages.ProfilePage
import com.example.techtrekkerbitnbuild.screenpages.SignUp
import com.example.techtrekkerbitnbuild.screenpages.UserStatus
import com.example.techtrekkerbitnbuild.screenpages.curUserId
import com.example.techtrekkerbitnbuild.screenrouter.Screen
import com.example.techtrekkerbitnbuild.screenrouter.ScreenRouter
import com.example.techtrekkerbitnbuild.ui.theme.TechTrekkerBitnBuildTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var curUser by mutableStateOf(UserData())
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userDao = UserDataBase.getInstance(this).userDao()



        setContent {
            TechTrekkerBitnBuildTheme(
                darkTheme = false
            ) {



                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TechTrekkerApp(userDao = userDao)
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TechTrekkerApp(userDao: UserDataDao) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = ScreenRouter.currentScreen) { currentState ->
            when(currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUp(userDao = userDao)
                }
                is Screen.LoginScreen -> {
                    LoginPage(userDao = userDao)
                }
                is Screen.HomeScreen -> {

                    Home()
                }
                is Screen.ProfileScreen -> {



                        ProfilePage(user = curUser )




                }

                is Screen.EditProfileScreen -> {
                    EditProfile()
                }
            }
        }
    }
}
