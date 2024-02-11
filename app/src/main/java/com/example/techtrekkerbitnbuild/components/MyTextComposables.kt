package com.example.techtrekkerbitnbuild.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabelTextBig(textVal : String) {
    Text(
        text = textVal,
fontWeight = FontWeight.Bold,
        fontSize = 24.sp,

        modifier = Modifier.padding(8.dp)
        )
}
@Composable
fun LabelText(textVal : String) {
    Text(
        text = textVal,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,

        textAlign = TextAlign.Start,
        modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun UserField(label: String, value: String) {
    Row (
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(12.dp)
    ){
        LabelText(textVal = label)
        MySpacer(8)
        Text(text = value)
    }
}
@Preview
    (
    showBackground = true,
//    showSystemUi = true

)
@Composable
fun Preview4() {
    LabelText("Some random")
}