package com.ibrajix.ajo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.airbnb.lottie.compose.LottieCompositionSpec.*
import com.ibrajix.ajo.R

@Composable
fun HomeScreen(navController: NavController){


    val composition by rememberLottieComposition(RawRes(R.raw.home))

    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
    )



    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        LottieAnimation(
            composition,
            progress = {
                progress
            }
        )

        Text(
            modifier = Modifier
                .padding(top = 20.dp),
            text = stringResource(id = R.string.congratulations),
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )

    }

}