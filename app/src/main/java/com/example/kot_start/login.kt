package com.example.kot_start

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.kot_start.repository.UserRepoImpl
//import com.example.kot_start.ui.theme.Blue
import com.example.kot_start.ui.theme.PurpleGrey80
import com.example.kot_start.ui.theme.LightBlue
import com.example.kot_start.ui.theme.follow
import com.example.kot_start.viewmodel.UserViewModel
import kotlin.jvm.java
import kotlin.reflect.KClass


class login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            loginPreview()
            }
        }
    }


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun loginBody() {
    val userViewModel= remember{ UserViewModel(UserRepoImpl()) };
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }
    val sharedPreferences= context.getSharedPreferences("User", MODE_PRIVATE)

    val activity = context as Activity
    Scaffold { padding ->
        Column {
            Spacer(modifier = Modifier.padding(25.dp))
            Text(
                "Sign In",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightBlue
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Text(
                "This is a faceboo. You can connect with many peopke in this app. Also you can do many thing ike boo boo blaa blaa",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                style = TextStyle(fontSize = 12.sp,),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(vertical = 12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                SocialMediaCard(
                    Modifier
                        .height(60.dp)
                        .weight(1f),
                    R.drawable.communication,
                    "Facebook"
                )
                Spacer(modifier = Modifier.width(20.dp))
                SocialMediaCard(
                    Modifier
                        .height(60.dp)
                        .weight(1f),
                    R.drawable.gmail,
                    "Gmail"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp, horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f)
                )
                Text("OR", modifier = Modifier.padding(horizontal = 20.dp))
                HorizontalDivider(
                    modifier = Modifier.weight(1f)
                )
            }

            Column {
                OutlinedTextField(
                    value = email,
                    onValueChange = { data ->
                        email = data
                    },
                    shape = RoundedCornerShape(15.dp),
                    placeholder = {
                        Text("abc@gmail.com")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = PurpleGrey80,
                        unfocusedContainerColor = PurpleGrey80,
                        focusedIndicatorColor = follow,
                        unfocusedIndicatorColor = Color.Transparent
                    )

                )

                Spacer(modifier = Modifier.padding(vertical = 12.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { data ->
                        password = data
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            visibility = !visibility
                        }) {
                            Icon(
                                painter = if (visibility)
                                    painterResource(R.drawable.baseline_visibility_24)
                                else
                                    painterResource(R.drawable.baseline_visibility_off_24),
                                contentDescription = null
                            )
                        }

                    },
                    visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
                    shape = RoundedCornerShape(15.dp),
                    placeholder = {
                        Text("********")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = PurpleGrey80,
                        unfocusedContainerColor = PurpleGrey80,
                        focusedIndicatorColor = LightBlue,
                        unfocusedIndicatorColor = Color.Transparent
                    )

                )

                Text(
                    "Forget password",
                    style = TextStyle(
                        textAlign = TextAlign.End
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            userViewModel.forgetPassword("ienvysnn@gmail.com"){
                                sucess,msg->
                                if(sucess){
                                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                }else{
                                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                }

                            }


                        }
                        .padding(vertical = 15.dp, horizontal = 15.dp)
                )

                Button(
                    onClick = {

                       userViewModel.login(email,password){
                           success,msg ->
                           if(success){
                               Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                               val intent = Intent(context,
                                   dashbaord::class.java)
                               context.startActivity(intent)
                           }else {
                               Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                           }
                       }

                    },
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp

                    ),
                    modifier = Modifier
                        .fillMaxWidth().height(60.dp)
                        .padding(horizontal = 15.dp),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text("Log In")
                }

                Spacer(modifier = Modifier.padding(vertical = 12.dp))
                Text(
                    modifier = Modifier.fillMaxWidth().clickable{
                        val intent = Intent(context, register::class.java)
                        context.startActivity(intent)
                        activity.finish()
                    },
                    textAlign = TextAlign.Center,
                    text = buildAnnotatedString {
                        append("Don't have an account? ")

                        withStyle(
                            style = SpanStyle(
                                color = Blue,
                                textDecoration = TextDecoration.Underline,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Sign up")
                        }
                    }
                )

            }


        }
    }
}



@Composable
fun SocialMediaCard(modifier: Modifier, image: Int, label: String) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(label)
        }
    }
}

@Composable
fun card() {

}
@Preview
@Composable
fun loginPreview(){
    loginBody()
}