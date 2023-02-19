package com.druniadler.orlov_vk_olimp.ui

import android.os.Bundle
import android.os.Parcelable
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.ImagePainter
import com.druniadler.orlov_vk_olimp.SetupNavGraph
import com.druniadler.orlov_vk_olimp.data.api.model.Service
import com.druniadler.orlov_vk_olimp.ui.homescreen.HomeScreen
import com.druniadler.orlov_vk_olimp.ui.theme.OrlovVKOlimpTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.parcel.Parcelize

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrlovVKOlimpTheme{
                navController =  rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MaterialTheme{
            Column() {
                TopAppBar() {

                }
            }
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

