package com.druniadler.orlov_vk_olimp

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.druniadler.orlov_vk_olimp.data.api.model.Service
import com.druniadler.orlov_vk_olimp.ui.homescreen.HomeScreen
import com.druniadler.orlov_vk_olimp.ui.homescreen.ServiceParcelable
import com.google.gson.Gson

class ServiceType : NavType<Service>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Service? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Service {
        return Gson().fromJson(value, Service::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Service) {
        bundle.putParcelable(key, value)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route
        ) {
            Column {
                TopAppBar(title={ Text(text = "Проекты VK")})
                HomeScreen(navController = navController)
            }
        }
        composable(
            route = Screen.Details.route + "/{service}",
            arguments = listOf(navArgument("service") {type = ServiceType()})
        ) {
            DetailsScreen(service = it.arguments?.getParcelable<Service>("service"))
        }
    }
}

