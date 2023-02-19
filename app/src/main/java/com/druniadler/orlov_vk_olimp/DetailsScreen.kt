package com.druniadler.orlov_vk_olimp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.druniadler.orlov_vk_olimp.data.api.model.Service
import com.druniadler.orlov_vk_olimp.ui.homescreen.ServiceParcelable

@Composable
fun DetailsScreen(service: Service?) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (service != null) {
            TopAppBar(
                title={
                    Text(
                        text = service.name,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            )
            Image(
                painter = rememberImagePainter(
                data = service.iconUrl),
                contentDescription = null,
                alignment = Alignment.TopCenter,
                modifier = Modifier.padding(
                    top = 26.dp,
                    start = 26.dp,
                    end = 26.dp,
                    bottom = 1.dp
                )
            )
            Text(
                text = service.name,
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = service.description,
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = service.serviceUrl,
                textAlign = TextAlign.Left,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(10.dp),
                style = TextStyle(color = Color(81,135,176))
            )
        }
    }
}
