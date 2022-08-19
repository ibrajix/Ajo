package com.ibrajix.ajo.ui.components

import android.widget.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ibrajix.ajo.R
import com.ibrajix.ajo.ui.theme.bgButton
import com.ibrajix.ajo.ui.theme.white

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit,
    buttonText: Int,
    buttonBackgroundColor: Color,
    buttonTextColor: Color
) {

    Button(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonBackgroundColor,
        ),
        onClick = {
            onClickButton()
        }
    )
    {
        Text(
            text = stringResource(id = buttonText),
            style = MaterialTheme.typography.caption,
            color = buttonTextColor,
            fontWeight = FontWeight.Bold
        )
    }

}