package com.example.techtrekkerbitnbuild.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Composable for Page Title
 */
@Composable
fun TitleText(pageText: String, fontSize: Int = 32, greet: Boolean = true, color: Color = Color.Black, modifier: Modifier =
    Modifier) {

    Column(
        modifier = Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (greet)
            Text(
                text = "Hey there,", modifier = Modifier, fontSize = 24.sp, textAlign = TextAlign.Center
            )

        MySpacer(h = 4)
        Text(
            text = pageText, fontSize = fontSize.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
            lineHeight = 36.sp, color = color

        )
    }
}




/**
 * Composable for CheckBox
 */
@Composable
fun MyCheckBox(contentText: String, modifier: Modifier = Modifier) : Boolean{
    var checkedState by remember {
        mutableStateOf(false)
    }
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {



        Checkbox(checked = checkedState, onCheckedChange = {
            checkedState = !checkedState
        })

        Text(
            text = contentText,
            modifier = Modifier,
            fontSize = 12.sp,
            textAlign = TextAlign.Start
        )
    }
    return checkedState
}




/**
 * Extension properties
 */
val String.color
    get() = Color(android.graphics.Color.parseColor(this))


/**
 * Modified modifiers
 */
@Composable
fun MySpacer(w: Int = 0, h: Int = 0) {
    Spacer(
        modifier = Modifier
            .height(h.dp)
            .width(w.dp)
    )
}


/**
 * Preview sections
 */
@Preview(
    showBackground = true,
)
@Composable
fun Preview1() {
//    TitleText(pageText = "Create an Account")
}


