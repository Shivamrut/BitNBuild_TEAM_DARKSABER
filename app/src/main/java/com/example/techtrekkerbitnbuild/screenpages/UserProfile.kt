package com.example.techtrekkerbitnbuild.screenpages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.techtrekkerbitnbuild.R
import com.example.techtrekkerbitnbuild.components.LabelTextBig
import com.example.techtrekkerbitnbuild.components.MyButton
import com.example.techtrekkerbitnbuild.components.MySpacer
import com.example.techtrekkerbitnbuild.components.UserField
import com.example.techtrekkerbitnbuild.databaseFiles.UserData
import com.example.techtrekkerbitnbuild.screenrouter.Screen
import com.example.techtrekkerbitnbuild.screenrouter.ScreenRouter

//fun generateRandomUser(): User {
//    val random = Random.Default
//
//    val id = random.nextInt(1, 1000)
//    val firstName = "John"
//    val lastName = "Doe"
//    val email = "john.doe@example.com"
//    val password = "password123"
//    val collegeName = "Example University"
//    val degree = "Computer Science"
//    val dob = "10,01,2004"
//    val city = City.values().random()
//    val state = State.values().random()
//    val imgRes = R.drawable.ic_launcher_background // assuming you have a default image resource
//    val eventsParticipated = random.nextInt(0, 100)
//    val achievements = listOf("Achievement 1", "Achievement 2")
//    val club = "Tech Club"
//    val phone = random.nextLong(1000000000, 9999999999)
//    val gender = Gender.values().random()
//    val bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
//    val skills = listOf("Java", "Kotlin", "Android", "Jetpack Compose")
//
//    return User(
//        id, firstName, lastName, email, password, collegeName,
//        degree, dob,
////        city, state,
//        imgRes, eventsParticipated,
////        achievements,
//        club, phone,
////        gender,
//        bio,
////        skills
//    )
//}


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ProfilePage(
    modifier: Modifier = Modifier,
    user : UserData
) {



    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color.White),
//        tonalElevation = 2.dp,
//        shadowElevation = 8.dp,
    ) {

        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.Top,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        modifier = Modifier.weight(1f),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null
                    )

                    MySpacer(20, 0)
                    Column(
                        modifier = Modifier.weight(3f),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        LabelTextBig(textVal = "Maxus Red")
                        LabelTextBig(textVal = "College Name")
                    }
                }
            }

            item {
                UserField(label = "ID:", value = user.id.toString())
                UserField(label = "DOB:", value = user.dob)
                UserField(label = "Phone:", value = user.phone.toString())
                UserField(label = "Email:", value = user.email)
                UserField(label = "Degree:", value = user.degree)
                UserField(label = "Club:", value = user.club)
//                UserField(label = "City:", value = user.city.name)
//                UserField(label = "State:", value = user.state.name)
                UserField(label = "Events Participated:", value = user.eventsParticipated.toString())
//                UserField(label = "Achievements:", value = user.achievements.joinToString())
//                UserField(label = "Gender:", value = user.gender.name)
                UserField(label = "Bio:", value = user.bio)
//                UserField(label = "Skills:", value = user.skills.joinToString())
                MySpacer(0,20)
            }

            item {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    MyButton(enabled = true, btnVal = "Edit", onClick = {


                        ScreenRouter.navigateTo(Screen.EditProfileScreen)

                    })
                }

            }
        }
    }


}


//@Preview
//    (
//    showBackground = true,
//    showSystemUi = true
//
//)
//@Composable
//fun Preview3() {
//    ProfilePage()
//}