package com.hendadev.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hendadev.diceroller.ui.theme.DicerollerTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DicerollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Diceroller()
                }
            }
        }
    }
}

@Composable
fun HeaderScreen(modifier: Modifier = Modifier) {
    TopAppBar(modifier = modifier.fillMaxWidth()) {
        Text(text = "Dice Roller",
            color = MaterialTheme.colors.background,
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var diceImage by remember { mutableStateOf(R.drawable.empty_dice) }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier) {

        Image(painter = painterResource(diceImage), contentDescription = null)

        Button(onClick = { diceImage = rollDice() },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)) {
            Text(text = "Rodar",
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 25.sp),
                modifier = Modifier.width(180.dp))
        }
    }
}

@Composable
fun Diceroller(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        HeaderScreen()
        HomeScreen(modifier = Modifier.fillMaxSize())
    }
}

private fun rollDice(): Int {
    val drawableResource = when (Random().nextInt(6) + 1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    return drawableResource
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun DefaultPreview() {
    DicerollerTheme {
        Diceroller()
    }
}