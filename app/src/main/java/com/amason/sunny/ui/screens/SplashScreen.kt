package com.amason.sunny.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amason.sunny.ui.theme.*
import com.amason.sunny.R

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

    Box(
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .padding(top = 160.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_weather1),
            contentDescription = "Weather logo"
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

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Get weather predictions and make your life easier",
                    fontFamily = ReemKufi,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = LightText
                )

                Spacer(modifier = Modifier.height(36.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = White,
                        backgroundColor = Primary,
                    ),
                    contentPadding = PaddingValues(horizontal = 30.dp, vertical = 10.dp),
                    modifier = Modifier.clip(shape = Shapes.medium),
                ) {
                    Text(text = "Get Started", fontSize = 18.sp)
                }
            }
        }
    }
}
