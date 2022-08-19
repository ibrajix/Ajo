package com.ibrajix.ajo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Colors.white : Color get() = White
val Colors.black : Color get() = Black
val Colors.mainBlue : Color get() = MainBlue
val Colors.mainGreen : Color get() = MainGreen
val Colors.bgGreen: Color get() = BgGreen
val Colors.bgButton: Color get() = ButtonGreen
val Colors.subTitle: Color get() = SubTitle
val Colors.errorColor: Color get() = ErrorRed

@Composable
fun AjoTheme(content: @Composable () -> Unit) {

    /**
     * You can implement a dark mode variant color if you want
     */

    MaterialTheme(
        typography = MyTypography,
        shapes = Shapes,
        content = content
    )
}