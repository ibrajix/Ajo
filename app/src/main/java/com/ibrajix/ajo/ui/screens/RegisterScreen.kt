package com.ibrajix.ajo.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.ajo.R
import com.ibrajix.ajo.ui.components.MyButton
import com.ibrajix.ajo.ui.components.MyEditText
import com.ibrajix.ajo.ui.events.AuthEvent
import com.ibrajix.ajo.ui.navigation.Routes
import com.ibrajix.ajo.ui.statesviewmodel.RegisterViewModel
import com.ibrajix.ajo.ui.theme.*
import com.ibrajix.ajo.utils.Utility.popUpToTop

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = hiltViewModel()
){

    val state = registerViewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context){

        registerViewModel.shouldNavigate.collect { event->
            if(event){
                //navigate to homeScreen
                navController.navigate(Routes.HomeScreen.route){
                    popUpToTop(navController)
                }
            }
        }

    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.white
    )

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .statusBarsPadding()
            .navigationBarsWithImePadding()
            .verticalScroll(rememberScrollState())
            .height(LocalConfiguration.current.screenHeightDp.dp)
            .fillMaxWidth()
    ) {

        Image(
            modifier = Modifier
                .size(18.dp)
                .clickable(
                    onClick = {
                        //go back
                        navController.popBackStack()
                    }
                ),
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
        )


        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.lets_get_started),
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.enter_your_details),
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.subTitle,
            fontSize = 18.sp
        )

        val firstNameModifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)

        val othersModifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)


        MyEditText(
            modifier = firstNameModifier,
            textValue = state.firstName,
            textLabel = R.string.first_name,
            hasError = state.firstNameErrorMessage != null,
            onTextValueChanged = {
                registerViewModel.onEvent(AuthEvent.FirstNameChanged(it))
            }
        )

        if (state.firstNameErrorMessage != null){
            Text(
                modifier = Modifier
                    .padding(top = 2.dp),
                text = state.firstNameErrorMessage,
                color = MaterialTheme.colors.errorColor
            )
        }

        MyEditText(
            modifier = othersModifier,
            textValue = state.lastName,
            textLabel = R.string.last_name,
            hasError = state.lastNameErrorMessage != null,
            onTextValueChanged = {
                registerViewModel.onEvent(AuthEvent.LastNameChanged(it))
            }
        )

        if (state.lastNameErrorMessage != null){
            Text(
                modifier = Modifier
                    .padding(top = 2.dp),
                text = state.lastNameErrorMessage,
                color = MaterialTheme.colors.errorColor
            )
        }


        MyEditText(
            modifier = othersModifier,
            textValue = state.number,
            keyboardType = KeyboardType.Number,
            textLabel = R.string.phone_number,
            hasError = state.numberErrorMessage != null,
            onTextValueChanged = {
                registerViewModel.onEvent(AuthEvent.NumberChanged(it))
            }
        )

        if (state.numberErrorMessage != null){
            Text(
                modifier = Modifier
                    .padding(top = 2.dp),
                text = state.numberErrorMessage,
                color = MaterialTheme.colors.errorColor
            )
        }

        MyEditText(
            modifier = othersModifier,
            textValue = state.password,
            shouldShowIconTrailingIcon = true,
            textLabel = R.string.password,
            hasError = state.passwordErrorMessage != null,
            onTextValueChanged = {
                registerViewModel.onEvent(AuthEvent.PasswordChanged(it))
            }
        )

        if (state.passwordErrorMessage != null){
            Text(
                modifier = Modifier
                    .padding(top = 2.dp),
                text = state.passwordErrorMessage,
                color = MaterialTheme.colors.errorColor
            )
        }

        //register button
        MyButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            onClickButton = {
                //go to home screen
                registerViewModel.onEvent(AuthEvent.Submit)
            },
            buttonText = R.string.register,
            buttonBackgroundColor = MaterialTheme.colors.bgButton,
            buttonTextColor = MaterialTheme.colors.white
        )

        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .clickable {
                    //go to register screen
                    navController.navigate(Routes.RegisterScreen.route)
                },
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.already_having_account),
                style = MaterialTheme.typography.caption,
                fontSize = 16.sp
            )

            Text(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .clickable {
                        navController.navigate(Routes.LoginScreen.route)
                    },
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.mainGreen,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

        }

    }

}