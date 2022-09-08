package com.amason.sunny.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amason.sunny.ui.theme.BottomShape
import com.amason.sunny.ui.theme.Primary
import com.amason.sunny.ui.theme.ReemKufi

@Composable
fun SplashScreenUI() {

    val annotatedString = AnnotatedString.Builder("Find weather predictions in your city")
        .apply {
            addStyle(
                SpanStyle(
                    color = Primary,
                    fontSize = 30.sp
                ), 0, 4
            )
        }

    Box(contentAlignment = Alignment.BottomCenter) {
        Card(
            modifier = Modifier
                .clip(BottomShape.medium)
                .fillMaxWidth()
                .height(350.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = annotatedString.toAnnotatedString(),
                    fontFamily = ReemKufi,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = "Hello")
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "CLick me")
                }
            }
        }
    }
}
