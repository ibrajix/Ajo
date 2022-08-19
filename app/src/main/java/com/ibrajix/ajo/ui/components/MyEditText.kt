package com.ibrajix.ajo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.ibrajix.ajo.R
import com.ibrajix.ajo.ui.theme.black
import com.ibrajix.ajo.ui.theme.mainGreen

@Composable
fun MyEditText(
    modifier: Modifier,
    textValue: String,
    textLabel: Int,
    hasError: Boolean? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    shouldShowIconTrailingIcon: Boolean = false,
    onTextValueChanged : (String) -> Unit
){

    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = modifier,
        value = textValue,
        isError = hasError ?: false,
        onValueChange = {
            onTextValueChanged(it)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (shouldShowIconTrailingIcon && passwordVisibility) PasswordVisualTransformation()  else VisualTransformation.None,
        label = {
            Text(
                text = stringResource(id = textLabel),
                fontWeight = FontWeight.Medium
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.mainGreen,
            focusedLabelColor = MaterialTheme.colors.mainGreen,
            cursorColor = MaterialTheme.colors.mainGreen,
            placeholderColor = MaterialTheme.colors.black,
        ),
        trailingIcon = {

            val passwordImage =  if (passwordVisibility){
                R.drawable.ic_password_show
            } else {
                R.drawable.ic_password_hide
            }

            if (shouldShowIconTrailingIcon){
                Icon(
                    painter = painterResource(id = passwordImage),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable{
                            passwordVisibility = !passwordVisibility
                        }
                )
            }



        }
    )

}