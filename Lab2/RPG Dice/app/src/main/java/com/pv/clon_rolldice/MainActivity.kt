package com.pv.clon_rolldice

// Android Core Imports
import android.os.Bundle
import android.util.Log

// AndroidX Activity imports
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// JetPack Compose Core
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


// constantes de la app

private const val TAG = "MainActivity"
private const val ANIMATION_ITERATIONS = 15
private const val ANIMATION_DELAY_MS = 80L
private const val MAX_DICE_VALUE = 20
private const val MIN_DICE_VALUE = 1

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate: Activity incializando...")
        Log.d(TAG,"onCreate: Edge-to-Edge habilitado...")
        setContent{
            MaterialTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    stateRown()
                }
            }
        }
        Log.d(TAG,"onCreate: UI generada Componente establecido correctamente")
    }
}

//// Component dado
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DiceRollerScreen(){
//    var diceValue by rememberSaveable { mutableIntStateOf(MIN_DICE_VALUE)}
//    var isRolling by remember{mutableStateOf(false)}
//    var resultMessage by rememberSaveable{mutableStateOf("Tocar el boton para lanzar")}
//    val coroutineScope = rememberCoroutineScope()
//
//    fun rollDice(){
//        Log.d(TAG,"rollDice: Inicializando el lanzamiento del dado")
//        coroutineScope.launch{
//            isRolling = true
//            resultMessage = "Lanzando..."
//            Log.d(TAG,"rollDice: Animación inciada")
//            repeat(ANIMATION_ITERATIONS){
//                iteration -> diceValue = (MIN_DICE_VALUE..MAX_DICE_VALUE).random()
//                Log.d(TAG,"rollDice:Iteración ${iteration + 1}/${ANIMATION_ITERATIONS}, valor temporal: $diceValue")
//                delay(ANIMATION_DELAY_MS)
//            }
//            val finalValue =  (MIN_DICE_VALUE..MAX_DICE_VALUE).random()
//            diceValue = finalValue
//            Log.d(TAG, "rollDice: resultado final: $finalValue")
//            isRolling=false
//            Log.d(TAG,"rollDice: Lanzamiento completo. Mensaje: $resultMessage")
//        }
//    }
//
//   Scaffold(
//       topBar={
//           TopAppBar(
//               title={
//                   Text(
//                       text = "RPG Dice Roller",
//                       style = MaterialTheme.typography.titleLarge
//                   )
//               }
//           )
//       }
//   ) {
//       paddingValues ->
//       Column(
//           modifier = Modifier
//               .fillMaxSize()
//               .padding(paddingValues)
//               .padding(horizontal = 24.dp),
//           horizontalAlignment = Alignment.CenterHorizontally,
//           verticalArrangement = Arrangement.Center
//       ){
//           Box(
//               modifier = Modifier
//                   .size(200.dp),
//               contentAlignment = Alignment.Center
//           ){
//               Text(
//                   text = diceValue.toString(),
//                   fontSize = 96.sp,
//                   fontWeight = FontWeight.Bold,
//                   color = getDiceValueColor(diceValue,isRolling),
//                   textAlign = TextAlign.Center
//               )
//           }
//           Spacer(modifier = Modifier.height(24.dp))
//           Text(
//               text = resultMessage,
//               style = MaterialTheme.typography.headlineSmall,
//               fontWeight = if (diceValue == MAX_DICE_VALUE || diceValue == MIN_DICE_VALUE){
//                   FontWeight.Bold
//               }else{
//                   FontWeight.Normal
//               },
//               color = getDiceValueColor(diceValue,isRolling),
//               textAlign = TextAlign.Center
//           )
//           Spacer(modifier = Modifier.height(48.dp))
//           Button(
//               onClick = {rollDice()},
//               enabled = !isRolling,
//               modifier = Modifier
//                   .fillMaxWidth()
//                   .height(56.dp),
//               colors = ButtonDefaults.buttonColors(
//                   containerColor = MaterialTheme.colorScheme.primary,
//                   disabledContainerColor = MaterialTheme.colorScheme.outline
//               )
//           ){
//               Icon(
//                   imageVector = Icons.Default.Refresh,
//                   contentDescription = "Lanzar Dado RPG",
//                   modifier = Modifier.size(24.dp)
//               )
//               Spacer(modifier = Modifier.size(8.dp))
//               Text(
//                   text = if (isRolling) "Lanzando..."else" Lanzar Dado RPG",
//                   fontSize = 18.sp,
//                   fontWeight = FontWeight.Bold
//               )
//           }
//           Spacer(modifier = Modifier.height(16.dp))
//           Text(
//               text = "Dado RPG",
//               style = MaterialTheme.typography.bodyMedium,
//               color = MaterialTheme.colorScheme.onSurfaceVariant
//               )
//       }
//   }
//}



// Character Componente
@Composable
fun CharacterScreen(){
    var vit by remember { mutableStateOf(10)}
    var dex by remember { mutableStateOf(10)}
    var wis by remember { mutableStateOf(10)}

    val suma = vit + dex + wis
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text("Stadisticas del personaje:", fontSize = 24.sp)
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
        Text("Total: $total", fontSize=20.sp)
        when{
            total < 30 -> Text(
                "Re-Roll recomended!"
                color=color.Red
            )
            Total>=50 -> Text(
                "Good"
                color = color.green
            )
        }
    }
}

// Función de colores
//private fun getDiceValueColor(value:Int,isRolling:Boolean):Color{
//    return when{
//        isRolling -> Color(0xFF666666)
//        value == MAX_DICE_VALUE -> Color(0xFFFFD700)
//        value == MIN_DICE_VALUE -> Color(0xFFDC143C)
//        else -> Color(0XFF333333)
//    }
//}

// la siguinte función permite ver los componentes sin ejecutar la app

//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    name = "Dice Roller Preview"
//)
//@Composable
//fun DiceRollerScreenPriview(){
//    MaterialTheme{
//        DiceRollerScreen()
//    }
//}