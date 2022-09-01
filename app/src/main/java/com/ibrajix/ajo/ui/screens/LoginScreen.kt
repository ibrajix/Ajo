package com.ibrajix.ajo.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import com.ibrajix.ajo.ui.statesviewmodel.LoginViewModel
import com.ibrajix.ajo.ui.statesviewmodel.RegisterViewModel

import com.ibrajix.ajo.ui.theme.*
import com.ibrajix.ajo.utils.Utility.popUpToTop

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
)

{

    val state = loginViewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context){
        loginViewModel.shouldNavigate.collect { event->
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
            text = stringResource(id = R.string.login_to_ajo),
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.welcome_back),
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.subTitle,
            fontSize = 18.sp
        )

        val firstModifier = Modifier
            .fillMaxWidth(0.4F)
            .padding(top = 20.dp)

        val secondModifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp)

        val othersModifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)

        Row(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
        ) {

            Column {

                MyEditText(
                    modifier = firstModifier,
                    textValue = state.country,
                    textLabel = R.string.country,
                    hasError = state.countryErrorMessage != null,
                    onTextValueChanged = {
                        loginViewModel.onEvent(AuthEvent.CountryChanged(it))
                    }
                )

                if (state.countryErrorMessage != null){
                    Text(
                        modifier = Modifier
                            .padding(top = 2.dp),
                        text = state.countryErrorMessage,
                        color = MaterialTheme.colors.errorColor
                    )
                }

            }

            Column {

                MyEditText(
                    modifier = secondModifier,
                    textValue = state.number,
                    keyboardType = KeyboardType.Number,
                    textLabel = R.string.phone_number,
                    hasError = state.numberErrorMessage != null,
                    onTextValueChanged = {
                        loginViewModel.onEvent(AuthEvent.NumberChanged(it))
                    }
                )

                if (state.numberErrorMessage != null){
                    Text(
                        modifier = Modifier
                            .padding(top = 2.dp, start = 10.dp),
                        text = state.numberErrorMessage,
                        color = MaterialTheme.colors.errorColor
                    )
                }
            }

        }

        MyEditText(
            modifier = othersModifier,
            textValue = state.password,
            textLabel = R.string.password,
            hasError = state.passwordErrorMessage != null,
            shouldShowIconTrailingIcon = true,
            onTextValueChanged = {
                loginViewModel.onEvent(AuthEvent.PasswordChanged(it))
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

        Text(
            modifier = Modifier
                .padding(top = 20.dp),
            text = stringResource(id = R.string.forgot_password),
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.mainGreen
        )

        //login
        MyButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            onClickButton = {
                loginViewModel.onEvent(AuthEvent.Submit)
            },
            buttonText = R.string.login,
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
                text = stringResource(id = R.string.dont_have_account),
                style = MaterialTheme.typography.caption,
                fontSize = 16.sp
            )

            Text(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .clickable {
                        navController.navigate(Routes.RegisterScreen.route)
                    },
                text = stringResource(id = R.string.create_one),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.mainGreen,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

        }


    }

}