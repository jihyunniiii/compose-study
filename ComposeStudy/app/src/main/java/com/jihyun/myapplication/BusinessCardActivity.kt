package com.jihyun.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jihyun.myapplication.ui.theme.ComposestudyTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposestudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF3ddc84)),
        verticalArrangement = Arrangement.Center
    ) {
        Profile(
            image = painterResource(id = R.drawable.android_logo),
            name = "Jennifer Doe",
            job = "Android Developer Extraordinaire"
        )
        Info()
    }
}

@Composable
fun Profile(
    image: Painter,
    name: String,
    job: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(0.8F)
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .width(150.dp)
                .height(150.dp)
                .background(Color(0xFF000000))
        )
        Text(
            text = name,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Text(
            text = job
        )
    }
}

@Composable
fun InfoItem(
    icon: Painter,
    context: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = context
        )
    }
}

@Composable
fun Info(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InfoItem(
            icon = painterResource(id = R.drawable.ic_phone_24),
            context = "+11 (123) 444 555 666"
        )
        InfoItem(
            icon = painterResource(id = R.drawable.ic_share_24),
            context = "@AndroidDev"
        )
        InfoItem(
            icon = painterResource(id = R.drawable.ic_email_24),
            context = "jen.doe@android.com"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    ComposestudyTheme {
        BusinessCard()
    }
}