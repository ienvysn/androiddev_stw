package com.example.kot_start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot_start.ui.theme.Kot_startTheme
import com.example.kot_start.ui.theme.spotiBlack
import com.google.android.gms.maps.model.Circle

class spotify : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpotifyBody()


        }
    }
}
@Composable
fun SpotifyBody(){
    Scaffold { padding ->
        Column(

            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = spotiBlack)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 12.dp, start = 10.dp, end = 10.dp)
            ) {
                Row(modifier = Modifier.weight(2f)) {
                    Text(
                        "Recently Played",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = "more",
                        tint = Color.White,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_history_24),
                        contentDescription = "more",
                        tint = Color.White,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_settings_24),
                        contentDescription = "more",
                        tint = Color.White
                    )
                }
            }
            Row(modifier = Modifier
                .padding(top = 18.dp)
                .fillMaxWidth()
            ) {


            Row(modifier = Modifier.padding(start = 10.dp).fillMaxWidth()){
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(end = 12.dp)) {
                Image(painter = painterResource(R.drawable.daniel),
                    contentDescription = null,
                    modifier = Modifier

                        .size(120.dp)
                        .clip(CircleShape)
                )
                Text(
                    "Daniel Ceaser",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(top = 10.dp)
                )
            }
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(R.drawable.kendrick),
                        contentDescription = null,
                        modifier = Modifier

                            .size(120.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        "Kendrick Lamar",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ), modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }}
Row (modifier=Modifier.fillMaxWidth().padding(top=18.dp, start = 10.dp, end = 10.dp), verticalAlignment = Alignment.CenterVertically){
    Row{
Image(painter = painterResource(R.drawable.wrapped),
    contentDescription = null,
    modifier = Modifier.size(50.dp),
    contentScale = ContentScale.Crop
)
    }
    Row (modifier = Modifier.weight(2f).padding(start = 8.dp)){

        Column {
            Text("SPOTIFYWRAPPED", style = TextStyle(color = Color.White, fontSize = 12.sp))
            Text("Your 2021 in review ",style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold))
        }

    }


}
Row (modifier = Modifier.fillMaxWidth().padding(top=12.dp,start = 10.dp, end = 10.dp), verticalAlignment = Alignment.CenterVertically){
    Column {
        Image(painter = painterResource(R.drawable.topsong), contentDescription = null, Modifier.size(140.dp))
        Text("Your top song 2021", style = TextStyle(color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(top = 8.dp))

    }
    Column(modifier = Modifier.padding(start = 14.dp)) {
        Image(painter = painterResource(R.drawable.wrapped2023), contentScale = ContentScale.Crop,contentDescription = null, modifier = Modifier.size(140.dp))
        Text("Your Artist Revealed", style = TextStyle(color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(top = 8.dp))

    }
}
Text("Editor's Pick", style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold), modifier = Modifier.padding( start = 12.dp, top = 14.dp))
            Row (modifier = Modifier.fillMaxWidth().padding(top=12.dp,start = 10.dp, end = 10.dp), verticalAlignment = Alignment.CenterVertically){
                Column {
                    Image(painter = painterResource(R.drawable.harry), contentDescription = null, modifier = Modifier.size(140.dp))
                    Text("Ed sheren, Big sean, Juice WRLD, Lavnik Maharjan", style = TextStyle(color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Medium),
                        modifier = Modifier.padding(top = 8.dp).size(width=140.dp, height=40.dp))

                }
                Column(modifier = Modifier.padding(start = 14.dp)) {
                    Image(painter = painterResource(R.drawable.joji), contentScale = ContentScale.Crop,contentDescription = null, modifier = Modifier.size(140.dp) )
                    Text("Mitsk, Tame Impala, Charlie XCX, Glass animal", style = TextStyle(color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Medium),
                        modifier = Modifier.padding(top = 8.dp).size(width=140.dp, height=40.dp))

                }
            }


        }
    }
}

@Preview
@Composable
fun SpotifyProfile(){
    SpotifyBody()
}