package com.ibrajix.ajo.utils

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

object Utility {
    fun NavOptionsBuilder.popUpToTop(navController: NavController) {
        popUpTo(navController.currentBackStackEntry?.destination?.route ?: return) {
            inclusive =  true
        }
    }
}