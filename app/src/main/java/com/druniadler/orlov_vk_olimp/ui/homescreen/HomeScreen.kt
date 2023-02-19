package com.druniadler.orlov_vk_olimp.ui.homescreen

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.druniadler.orlov_vk_olimp.data.api.model.Service
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import com.druniadler.orlov_vk_olimp.Screen
import com.druniadler.orlov_vk_olimp.navigate
import com.google.gson.Gson
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ServiceParcelable(
    val description: String,
    val iconUrl: String,
    val name: String,
    val serviceUrl: String
) : Parcelable


@Composable
fun HomeScreen(navController: NavController) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val state by homeViewModel.state.collectAsState()

    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }

        items(state) {service: Service ->
            ServiceCard(service = service, navController =  navController)
        }
    }
}

@Composable
fun ServiceCard(service: Service, navController: NavController) {
    val imagerPainter = rememberImagePainter(data = service.iconUrl)

    Row( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .clickable {
            val serviceJson = Uri.encode(Gson().toJson(service))
            navController.navigate(Screen.Details.route + "/${serviceJson}")
        }) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = imagerPainter,
                contentDescription = null,
                modifier = Modifier.height(46.dp)
            )
            Text(
                text = service.name,
                modifier = Modifier
                    .padding(8.dp),
                color = Color(0xff595959),
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center
            )
        }
    }

}

