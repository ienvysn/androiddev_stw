package com.example.kot_start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot_start.ui.theme.Kot_startTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.kot_start.ui.theme.LightBlue
import com.example.kot_start.ui.theme.follow

class ProfileActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileBody()
                }
            }
        }
@Composable
fun ProfileBody() {
    Scaffold { padding ->
        Column(
            modifier = Modifier // This Modifier should be on the outermost Column inside Scaffold
                .padding(padding)
                .fillMaxSize()
                .background(color = Color.White),


        ) {
            Row (
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 12.dp, end = 12.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = null,
                    tint = Color.Black,
                )
                Text("Lavnik", style = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                )
                Icon(painter= painterResource(R.drawable.baseline_more_horiz_24),
                    contentDescription = null,
                    tint = Color.Black,
                    )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,


            ) {
                Image(
                    painter = painterResource(R.drawable.hami),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(80.dp).clip(CircleShape)

                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "10", style = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "Post", style = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
//                        fontWeight = FontWeight.Bold
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "1000", style = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "Follower", style = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
//                        fontWeight = FontWeight.Bold
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "90", style = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "following", style = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
//                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 12.dp, end = 12.dp),
            ) {
                Text(
                    "ienvysnn", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(bottom = 4.dp)
                )
                Text("This is a bio of mine . Lorem lorem ipsum bla bla",
                    modifier = Modifier.padding(bottom = 4.dp))
                Text("Link goes here", style = TextStyle(
                    color = Color.Blue,
                ), modifier = Modifier.padding(bottom = 4.dp))
                Text("Followed by one and two")
            }

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 10.dp, end = 9.dp),){
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth(),
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.White, Color.Black)
                    ) {
                        Text("Button",style = TextStyle(fontWeight = FontWeight.Medium))
                    }

                Row(){
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.padding(end=10.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(follow, Color.Black)

                    ) {
                        Text("Message",style = TextStyle(fontWeight = FontWeight.Medium))
                    }
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.padding(end=9.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.White, Color.Black)
                    ) {
                        Text("Message",style = TextStyle(fontWeight = FontWeight.Medium))
                    }
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.padding(end=9.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.White, Color.Black)
                    ) {
                        Text("Message",style = TextStyle(fontWeight = FontWeight.Medium))
                    }
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.width(50.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),contentDescription = null)
                    }

                }
                }


            Row (modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 12.dp, end = 12.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.high1),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .border(
                                BorderStroke(1.dp, Color.Gray),
                                CircleShape
                            )
                            .padding(2.dp)
                            .clip(CircleShape)
                    )
                    Text("Story 1", modifier = Modifier.padding(top = 4.dp))
                }
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.high2),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .border(
                                BorderStroke(1.dp, Color.Gray),
                                CircleShape
                            )
                            .padding(2.dp)
                            .clip(CircleShape)
                    )
                    Text("Story 2", modifier = Modifier.padding(top = 4.dp))
                }
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.high3),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .border(
                                BorderStroke(1.dp, Color.Gray),
                                CircleShape
                            )
                            .padding(2.dp)
                            .clip(CircleShape)
                    )
                    Text("Story 3", modifier = Modifier.padding(top = 4.dp))
                }
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.high4),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .border(
                                BorderStroke(1.dp, Color.Gray),
                                CircleShape
                            )
                            .padding(2.dp)
                            .clip(CircleShape)
                    )
                    Text("Story 4", modifier = Modifier.padding(top = 4.dp))
                }
                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.high5),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .border(
                                BorderStroke(1.dp, Color.Gray),
                              CircleShape
                            )
                            .padding(2.dp)
                            .clip(CircleShape) // this should be after all the paddng haru
                    )
                    Text("Story 5", modifier = Modifier.padding(top = 4.dp))
                }

            }
        }
    }
}


@Preview
@Composable
fun PreviewProfileBody(){
    ProfileBody()
}


// modifier.width(2)