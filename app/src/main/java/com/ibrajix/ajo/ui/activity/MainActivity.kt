package com.ibrajix.ajo.ui.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.ibrajix.ajo.ui.navigation.SetUpNavGraph
import com.ibrajix.ajo.ui.theme.AjoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)

        setContent {

            ProvideWindowInsets {
                AjoTheme {
                    navController = rememberNavController()
                    SetUpNavGraph(navController = navController)
                }
            }

        }

    }

}
