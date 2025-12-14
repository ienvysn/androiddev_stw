package com.example.kot_start
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {
    val images = listOf(
        R.drawable.high1,
        R.drawable.high2,
        R.drawable.high3,
        R.drawable.high4,
        R.drawable.high5,
        R.drawable.harry,
        R.drawable.joji,
        R.drawable.snoppy,
        R.drawable.wopper
    )

    val imaName = listOf("Batman", "Spiderman", "Roblox", "Gojo", "Silk","Harry","Joji","snoopy","wopper")
    val product = listOf(
        R.drawable.hoodie,
        R.drawable.tshirt,
        R.drawable.jacket,
        R.drawable.jeanjacket,
        R.drawable.jeansjacket,
        R.drawable.many,
        R.drawable.retro,
        R.drawable.dino,
        R.drawable.zipup
    )

    val imaPrice = listOf("1200", "500", "760", "999", "200","250","800")
    val productPrice = listOf("2100", "1500", "1760", "999", "2200","1250","800")

    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth().background(Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .shadow(elevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_search_24),
                            contentDescription = "Search Icon"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Search", style = TextStyle(color = Color.Gray))
                    }
                }


                Spacer(Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .shadow(elevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_location_on_24),
                            contentDescription = "Location Icon"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Location", style = TextStyle(fontWeight = FontWeight.Bold,))
                            Text("Select your location", style = TextStyle(fontSize = 10.sp))
                        }
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_drop_down_24),
                            contentDescription = "Dropdown Arrow"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(R.drawable.salebanner),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
                LazyRow {
                    items(images.size) { index ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(images[index]),contentDescription = null, modifier = Modifier.size(80.dp).padding(end = 5.dp), contentScale = ContentScale.Crop
                            )
                            Text(imaName[index], textAlign = TextAlign.Center);
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

            }
        }

        item() {
            Spacer(modifier = Modifier.height(20.dp))

            Text("Flash sale", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp), modifier = Modifier.padding(horizontal = 10.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Only few items left, Ending soon",modifier = Modifier.padding(horizontal = 10.dp))
                Text("20 items left ->", style = TextStyle(color = Color.Red))
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
                    LazyRow {
                        items(images.size) { index ->
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .padding(horizontal = 4.dp)
                                    .shadow(elevation = 10.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
                                    Image(
                                        painter = painterResource(images[index]),
                                        contentDescription = null,
                                        modifier = Modifier.size(100.dp),
                                        contentScale = ContentScale.Crop
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), horizontalAlignment = Alignment.Start) {
                                        Text(imaName[index])
                                        Text("RS." + imaPrice[index], style = TextStyle(color = Color.Red))
                                    }
                                }
                            }
                        }
                    }
                }
        item() {
            Spacer(modifier = Modifier.height(20.dp))

            Text("Recommended for you", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp), modifier = Modifier.padding(horizontal = 10.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Buy them before its too late!",modifier = Modifier.padding(horizontal = 10.dp))
                Text("see all", style = TextStyle(color = Color.Red))
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        item{
        LazyRow {
            items(images.size) { index ->
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .padding(horizontal = 4.dp)
                        .shadow(elevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
                        Image(
                            painter = painterResource(product[index]),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), horizontalAlignment = Alignment.Start) {
                            Text(imaName[index])
                            Text("RS." + productPrice[index], style = TextStyle(color = Color.Red))
                        }
                    }
                }
            }
        }}
            }
        }


@Preview
@Composable
fun HomePreview(){
    HomeScreen()
}