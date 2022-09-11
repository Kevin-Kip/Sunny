package com.amason.sunny.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amason.sunny.R
import com.amason.sunny.ui.theme.*

@Composable
fun HomeScreenUI() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Search for city",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center,
            fontFamily = ReemKufi,
            color = LightText
        )

        SearchBox()

        Cards()

        MoreCitiesButton()

        DataBox()
    }
}

@Composable
fun DataBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth(),
            elevation = 0.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(
                        text = "Precipitation",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "35%",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                    Text(
                        text = "Humidity",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "45%",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .height(150.dp)
                        .background(LightText)
                )

                Column {
                    Text(
                        text = "Wind",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "35 km/h",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                    Text(
                        text = "Pressure",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "45pha",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                }
            }
        }

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Image(
                painter = painterResource(id = R.drawable.ic_weather3), contentDescription = "",
                modifier = Modifier.padding(top = 1.dp)
            )
        }
    }
}

@Composable
fun MoreCitiesButton() {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = White,
            contentColor = LightText
        ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
        modifier = Modifier.clip(shape = Shapes.small),
        onClick = { /*TODO*/ },
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "More Cities", fontSize = 14.sp, fontFamily = Poppins)

            Spacer(modifier = Modifier.size(10.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "",
                tint = LightText,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun Cards() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeatherCard(
            temperature = "30oC",
            city = "Nairobi",
            wind = "30km/h",
            humidity = "76%",
            resourceId = R.drawable.ic_weather2
        )

        WeatherCard(
            temperature = "24oC",
            city = "Mombasa",
            wind = "12km/h",
            humidity = "48%",
            resourceId = R.drawable.ic_weather2
        )
    }
}

@Composable
fun WeatherCard(
    temperature: String,
    city: String,
    wind: String,
    humidity: String,
    resourceId: Int
) {
    Card(backgroundColor = White, elevation = 0.dp) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .padding(10.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(painter = painterResource(id = resourceId), contentDescription = "")
        }

        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = city, fontFamily = Poppins, fontSize = 14.sp, color = LightText)

            Text(
                text = formatTemperature(temperature),
                fontFamily = Poppins,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = DarkGrey
            )

            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_drop), contentDescription = "",
                    modifier = Modifier.size(14.dp), tint = LightIcon
                )

                Text(text = humidity, color = LightText, fontFamily = Poppins, fontSize = 12.sp)

                Spacer(modifier = Modifier.size(10.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_wind),
                    contentDescription = "",
                    modifier = Modifier.size(14.dp),
                    tint = LightIcon
                )

                Text(text = wind, color = LightText, fontFamily = Poppins, fontSize = 12.sp)
            }
        }
    }
}

fun formatTemperature(temperature: String): AnnotatedString {
    return AnnotatedString.Builder(temperature)
        .apply {
            addStyle(
                SpanStyle(fontSize = 18.sp, baselineShift = BaselineShift.Superscript), 2, 3
            )
        }
        .toAnnotatedString()
}

@Composable
fun SearchBox() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = null,
        placeholder = { Text("Search") },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp, bottom = 8.dp)
            .clip(SearchShape.medium),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search), contentDescription = "",
                modifier = Modifier.size(20.dp),
                tint = LightText
            )
        }
    )
}