package com.ibrajix.ajo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ibrajix.ajo.ui.screens.*

@Composable
fun SetUpNavGraph(
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route,
    ){
        composable(
          route = Routes.SplashScreen.route
        ){
            SplashScreen(navController)
        }

        composable(
            route = Routes.LoginRegisterScreen.route
        ){
            LoginRegisterScreen(navController)
        }

        composable(
            route = Routes.LoginScreen.route
        ){
            LoginScreen(navController)
        }

        composable(
            route = Routes.RegisterScreen.route
        ){
            RegisterScreen(navController)
        }

        composable(
            route = Routes.HomeScreen.route
        ){
            HomeScreen(navController)
        }

    }

}