package com.pv.clon_rolldice

// Android Core Imports
import android.os.Bundle
import android.util.Log

// AndroidX Activity imports
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// JetPack Compose Core
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

// MaterialUI3
import androidx.compose.material3.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

// Compose Runtime(UseState, UseEffect)
// estas son las las Apis para menejar los estados del componente
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

// Compose UI
// utilidades para modificar la apariencia y comportamiento de los componentes
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Kotlin Corouitines
// Corutinas que nos permiten ejecutar codigo de manera asincrona
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch






class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstancesState: Bundle? ){
        super.onCreate(savedInstancesState)
        setContent{
            MaterialTheme{
                CharacterScreen()
            }
        }
    }
}


// StatRow Componente
@Composable
fun StatRow(name:String,value:Int,onRoll:()-> Unit){

    Card{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(name,fontSize = 18.sp)
            Text(value.toString(), fontSize = 18.sp)
            Button(onClick = onRoll){
                Text("Roll")
            }
        }
    }

}

// Character Componente
@Composable
fun CharacterScreen(){
    var str by remember { mutableStateOf(10)}
    var dex by remember { mutableStateOf(10)}
    var intStat by remember { mutableStateOf(10)}

    val suma = str + dex + intStat
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text("Estadisticas del personaje:", fontSize = 24.sp)
        StatRow("STR",str){
            str = (1..20).random()
        }
        StatRow("DEX",dex){
            dex = (1..20).random()
        }
        StatRow("INT",intStat){
            intStat=(1..20).random()
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text("Total: $suma", fontSize=20.sp)
        when{
            suma < 30 -> Text(
                "Re-Roll recomended!",
                color=Color.Red
            )
            suma>=50 -> Text(
                fontSize = fontSize(14.dp)
                "Good",
                color = Color.Green
            )
        }
    }
}