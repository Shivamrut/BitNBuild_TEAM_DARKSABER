package com.example.techtrekkerbitnbuild.screenpages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.techtrekkerbitnbuild.components.DetailsTextField
import com.example.techtrekkerbitnbuild.components.MyButton
import com.example.techtrekkerbitnbuild.components.MySpacer
import com.example.techtrekkerbitnbuild.components.TitleText
import com.example.techtrekkerbitnbuild.screenrouter.Screen
import com.example.techtrekkerbitnbuild.screenrouter.ScreenRouter

@Composable
fun EditProfile() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color.White),
//        tonalElevation = 2.dp,
//        shadowElevation = 8.dp,
    ) {

        LazyColumn(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            item {
                TitleText(pageText = "Edit User Profile Details", greet = false)
            }



            item {
                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                ) {

                    DetailsTextField(labelVal = "First Name", onValueChange = {
//                    println("Main: $firstName")

                    })
                    MySpacer(h = 12)



                    DetailsTextField(labelVal = "Last Name", onValueChange = {
                    })
                    MySpacer(h = 12)



                    DetailsTextField(labelVal = "Date of Birth", onValueChange = {
                    })
                    MySpacer(h = 12)



                    DetailsTextField(labelVal = "Phone Number", onValueChange = {
//                    println("Main: $firstName")

                    })
                    MySpacer(h = 12)



                    DetailsTextField(labelVal = "University Name", onValueChange = {
                    })
                    MySpacer(h = 12)


                    DetailsTextField(labelVal = "Degree", onValueChange = {
                    })
                    MySpacer(h = 12)


                    DetailsTextField(labelVal = "Club", onValueChange = {
//                    println("Main: $firstName")

                    })
                    MySpacer(h = 12)


                    DetailsTextField(labelVal = "Bio", onValueChange = {
                    })
                    MySpacer(h = 12)


                }

            }
            item {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    MyButton(enabled = true, btnVal = "Save", onClick = {


                        ScreenRouter.navigateTo(Screen.ProfileScreen)
                    })
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
fun Preview4() {
    EditProfile()
}