package com.ibrajix.ajo.ui.navigation

sealed class Routes(val route: String){

    object SplashScreen: Routes(route = "splash_screen")
    object LoginRegisterScreen: Routes(route = "login_register_screen")
    object RegisterScreen: Routes(route = "register_screen")
    object LoginScreen: Routes(route = "login_screen")
    object HomeScreen: Routes(route = "home_screen")

}
