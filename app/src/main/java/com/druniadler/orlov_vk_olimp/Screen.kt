package com.druniadler.orlov_vk_olimp

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Details: Screen(route = "details_screen")
}
