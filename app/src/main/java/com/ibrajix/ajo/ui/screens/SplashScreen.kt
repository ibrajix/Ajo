package com.ibrajix.ajo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.ajo.R
import com.ibrajix.ajo.ui.navigation.Routes
import com.ibrajix.ajo.ui.theme.white
import com.ibrajix.ajo.utils.Utility.popUpToTop
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.white
    )

    Column {

        var progress by remember {
            mutableStateOf(0f)
        }

        LaunchedEffect(key1 = true){
            while (progress < 1){
                delay(10L)
                progress += 0.02000F
            }
            navController.navigate(Routes.LoginRegisterScreen.route){
                popUpToTop(navController)
            }
        }


        DisplayBranding(progress = progress)

    }
}


@OptIn(ExperimentalMotionApi::class)
@Composable
fun DisplayBranding(progress: Float){
    
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_ajo),
            contentDescription = null,
            modifier = Modifier
                .layoutId("logo")
        )


        Image(
            painter = painterResource(id = R.drawable.ic_branding),
            contentDescription = null,
            modifier = Modifier
                .layoutId("branding")
        )

    }
}