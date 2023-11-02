package com.jihyun.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jihyun.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> LemonadeItem(
                image = painterResource(id = R.drawable.lemon_tree),
                context = stringResource(id = R.string.lemon_tree_context),
                contentDescription = stringResource(id = R.string.lemon_tree),
                clickEvent = {
                    currentStep = 2
                    squeezeCount = (2..4).random()
                })

            2 -> LemonadeItem(
                image = painterResource(id = R.drawable.lemon_squeeze),
                context = stringResource(id = R.string.lemon_context),
                contentDescription = stringResource(id = R.string.lemon),
                clickEvent = {
                    squeezeCount -= 1

                    if (squeezeCount == 0) {
                        currentStep = 3
                    }
                })

            3 -> LemonadeItem(
                image = painterResource(id = R.drawable.lemon_drink),
                context = stringResource(id = R.string.glass_of_lemonade_context),
                contentDescription = stringResource(id = R.string.glass_of_lemonade),
                clickEvent = {
                    currentStep = 4
                })

            4 -> LemonadeItem(
                image = painterResource(id = R.drawable.lemon_restart),
                context = stringResource(id = R.string.empty_glass_context),
                contentDescription = stringResource(id = R.string.empty_glass),
                clickEvent = {
                    currentStep = 1
                })
        }
    }
}

@Composable
fun LemonadeItem(
    image: Painter,
    context: String,
    contentDescription: String,
    clickEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = clickEvent,
    ) {
        Image(
            painter = image,
            contentDescription = contentDescription,
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = context)
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    Lemonade(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}