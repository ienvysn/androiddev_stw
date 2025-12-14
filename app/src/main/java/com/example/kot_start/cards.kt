package com.example.kot_start

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot_start.ui.theme.Kot_startTheme
import com.example.kot_start.ui.theme.cardback
import com.example.kot_start.ui.theme.greenback

class cards : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardPreview()
                }
            }
        }


@Composable
fun CardBody(){
    Scaffold{paddingValues ->
        Column (modifier = Modifier.fillMaxSize().background(greenback).padding(paddingValues)){

            Row (modifier = Modifier.fillMaxWidth().padding(top = 20.dp, start = 10.dp, end = 10.dp),horizontalArrangement = Arrangement.End,){
                Image(painter = painterResource(R.drawable.high5),contentDescription = null,
                    Modifier.size(50.dp).clip(CircleShape) )
            }

//          l  Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Column (modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp)){
                Text("Card", style = TextStyle(fontSize = 36.sp, color = Color.White, fontWeight = FontWeight.Medium))
                Text("Simple and easy to use app", style = TextStyle(fontSize = 22.sp, color = Color.White.copy(0.7f), fontWeight = FontWeight.Medium))
            }
            Spacer(modifier = Modifier.padding(vertical = 20.dp))


            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp,vertical = 10.dp)){
                CardMaker(modifier = Modifier.weight(1f) .height(170.dp).padding(end = 10.dp).background(
                    cardback, shape = RoundedCornerShape(10.dp)
                ), image = R.drawable.card,label = "Text")
                CardMaker(modifier = Modifier.weight(1f) .height(170.dp).padding(horizontal = 10.dp).background(
                    cardback, shape = RoundedCornerShape(10.dp)
                ), image = R.drawable.human,label = "Address")
            }
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 10.dp)){
                CardMaker(modifier = Modifier.weight(1f) .height(170.dp).padding(end = 10.dp).background(
                    cardback, shape = RoundedCornerShape(10.dp)
                ), image = R.drawable.curch,label = "Character")
                CardMaker(modifier = Modifier.weight(1f) .height(170.dp).padding(horizontal = 10.dp).background(
                    cardback, shape = RoundedCornerShape(10.dp)
                ), image = R.drawable.communication,label = "Bank")
            }
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 10.dp)){
                CardMaker(modifier = Modifier.weight(1f) .height(170.dp).padding(end = 10.dp).background(
                    cardback, shape = RoundedCornerShape(10.dp)
                ), image = R.drawable.high4,label = "Password")
                CardMaker(modifier = Modifier.weight(1f) .height(170.dp).padding(horizontal = 10.dp).background(
                    cardback, shape = RoundedCornerShape(10.dp)
                ), image = R.drawable.high4,label = "Logistic")
            }

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 10.dp).background(cardback, shape = RoundedCornerShape(10.dp)).height(70.dp).padding(horizontal = 15.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.baseline_settings_24),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).weight(1f)
                )
                Column(modifier = Modifier.padding(start = 5.dp).weight(5f)) {
                    Text("Setting", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Text("Bla bal bal", color = Color.Gray)
                }
            }
            }
            }

        }


@Composable
fun CardMaker(modifier: Modifier, image: Int, label: String){
    Row (modifier = modifier,){
        Column(){
            Image(painter = painterResource(image,),contentDescription = null,modifier= Modifier.fillMaxWidth().padding(top = 20.dp).size(100.dp) )
            Text(label, style = TextStyle(fontSize = 26.sp, color = Color.Black, fontWeight = FontWeight.Medium), modifier = Modifier.padding(top = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)

        }
    }
}
@Preview(showBackground = true)
@Composable
fun CardPreview() {
    CardBody()
}