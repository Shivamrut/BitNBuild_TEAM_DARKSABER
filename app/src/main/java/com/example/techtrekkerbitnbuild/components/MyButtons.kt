package com.example.techtrekkerbitnbuild.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(
    enabled :Boolean,
    onClick: () -> Unit = {}, btnVal: String,
    modifier:
    Modifier = Modifier
) {

    Button(
        enabled = enabled,
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
//        modifier = Modifier.height(40.dp).width(120.dp)
    ) {
        Text(btnVal)
    }
}
