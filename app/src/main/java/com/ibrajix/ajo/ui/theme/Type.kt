package com.ibrajix.ajo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ibrajix.ajo.R

//custom font
val Circular =  FontFamily(
    Font(R.font.circular_std_medium, FontWeight.Medium),
    Font(R.font.circular_std_regular, FontWeight.Normal),
)

val MyTypography = Typography(

    defaultFontFamily = Circular,

    h1 = TextStyle(
        fontFamily = Circular,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),

    h2 = TextStyle(
        fontFamily = Circular,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),

    h3 = TextStyle(
        fontFamily = Circular,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

    caption = TextStyle(
        fontFamily = Circular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

)