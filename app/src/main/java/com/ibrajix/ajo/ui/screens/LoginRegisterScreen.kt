package com.ibrajix.ajo.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.ajo.R
import com.ibrajix.ajo.ui.navigation.Routes
import com.ibrajix.ajo.ui.theme.*


@Composable
fun LoginRegisterScreen(navController: NavController){

    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.bgGreen
    )

    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.bgGreen),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .padding(top = 40.dp),
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.white,
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(R.drawable.ajo_graph),
            modifier = Modifier
                .size(200.dp)
                .padding(top = 50.dp)
                .graphicsLayer {
                    rotationZ = angle
                },
            contentDescription = null
        )

        Text(
            text = stringResource(id = R.string.save_more_community),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.white,
            modifier = Modifier
                .padding(50.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.white
            ),
            onClick = {
                //navigate to login screen
                navController.navigate(Routes.LoginScreen.route)
            }
        )
        {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.black,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 20.dp, end = 20.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.bgButton
            ),
            onClick = {
                //navigate to register screen
                navController.navigate(Routes.RegisterScreen.route)
            }
        )
        {
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.white,
                fontWeight = FontWeight.Bold
            )
        }


    }

}