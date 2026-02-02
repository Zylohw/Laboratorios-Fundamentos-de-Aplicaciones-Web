package com.pv.semaforo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ){
                    // componente
                    TrafficLightScreen()
                }
            }
        }
    }
}

enum class Light{
    Red,
    Yellow,
    Green
}

@Composable
fun TrafficLightScreen(){
    var currentLight by remember {mutableStateOf(Light.Red)}
    LaunchedEffect(Unit){
        while(true){
            currentLight = Light.Red
            delay(2000)
            currentLight = Light.Green
            delay(2000)
            currentLight = Light.Yellow
            delay(1000)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TrafficLightCircle(
            color = if(currentLight == Light.Red)Color.Red else Color.DarkGray
        )
        Spacer(modifier = Modifier.height(16.dp))
        TrafficLightCircle(
            color = if(currentLight == Light.Yellow) Color.Yellow else Color.DarkGray
        )
        Spacer(modifier = Modifier.height(16.dp))
        TrafficLightCircle(
            color = if(currentLight == Light.Green)Color.Green else Color.DarkGray
        )
    }
}

@Composable
fun TrafficLightCircle(color:Color){
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(color)
    )
}