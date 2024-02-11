package com.example.techtrekkerbitnbuild.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Composable for Normal TextFields
 */
@Composable
fun DetailsTextField(labelVal: String,onValueChange : (String)-> Unit, modifier: Modifier = Modifier) {

    var textValue by remember {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        label = {
            Text(
                text = labelVal,
                fontSize = 24.sp
            )
        },
//        colors = ,
        value = textValue,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done), // Set ImeAction to Done
        keyboardActions = KeyboardActions(onDone = { // Dismiss keyboard when Done action is triggered
            // Dismiss keyboard action
            keyboardController?.hide() // Use the retrieved keyboardController
        }),
        onValueChange = {
            textValue = it
            onValueChange(it)
//            println("Sub: $textValue")

        },
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(25))
//            .background("#E5E4E2".color)
//            .padding(bottom = 20.dp),
        ,

        leadingIcon = {
            Icon(Icons.Default.AccountBox, contentDescription = null)
        }

    )

}


/**
 * Composable for Password TextField
 */
@Composable
fun PasswordTextField(
    onValueChange : (String)-> Unit,
    modifier: Modifier = Modifier
) {

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        label = {
            Text(
                text = "Password",
                fontSize = 24.sp
            )
        },
//        colors = ,
        value = password,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ), // Set ImeAction to Done
        keyboardActions = KeyboardActions(onDone = { // Dismiss keyboard when Done action is triggered
            // Dismiss keyboard action
            keyboardController?.hide() // Use the retrieved keyboardController
        }),
        onValueChange = {
            password= it
            onValueChange(it)
        },
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(25))
//            .background("#E5E4E2".color)
//            .padding(bottom = 20.dp),
        ,

        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = null)
        },
        trailingIcon = {
            val iconImage = if (passwordVisible) {
                Icons.Filled.Visibility

            } else {
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible) {
                "Hide Password"

            } else {
                "Show Password"
            }

            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {

                Icon(imageVector = iconImage, contentDescription = "null")
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation()

    )
}