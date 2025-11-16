package com.example.kot_start

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kot_start.ui.theme.Kot_startTheme
import java.util.concurrent.CountDownLatch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainBody()

        }
    }
}

@Composable
fun MainBody(){
    Column(
        modifier = Modifier.fillMaxSize()
    .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly)

    {
        Text("hi")
        Text("HELOOOOOO",style= TextStyle(
            color = colorResource(com.example.kot_start.R.color.jason),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
            ))
        Text("SUBHAMMM", style = TextStyle(
            color = Color.Red,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        ))
    }
}

    @Preview
    @Composable
    fun PreviewMain(){
        MainBody()
    }