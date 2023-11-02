package com.jihyun.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jihyun.myapplication.ui.theme.ComposestudyTheme

class ComposeTutorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposestudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeTutorial(
                        image = painterResource(id = R.drawable.bg_compose_background),
                        title = stringResource(id = R.string.compose_tutorial_title),
                        section1 = stringResource(id = R.string.compose_tutorial_section1),
                        section2 = stringResource(id = R.string.compose_tutorial_section2)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeTutorial(
    image: Painter,
    title: String,
    section1: String,
    section2: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null)
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = section1,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = section2,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposestudyTheme {
        ComposeTutorial(
            image = painterResource(id = R.drawable.bg_compose_background),
            title = stringResource(id = R.string.compose_tutorial_title),
            section1 = stringResource(id = R.string.compose_tutorial_section1),
            section2 = stringResource(id = R.string.compose_tutorial_section2)
        )
    }
}