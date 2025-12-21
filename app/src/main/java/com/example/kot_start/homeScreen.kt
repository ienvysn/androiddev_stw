package com.example.kot_start
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot_start.repository.ProductRepoImlp
import com.example.kot_start.viewmodel.ProductViewModel


@Composable
fun HomeScreen() {
    var productName by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productStock by remember { mutableStateOf("") }
//    val images = listOf(
//        R.drawable.high1,
//        R.drawable.high2,
//        R.drawable.high3,
//        R.drawable.high4,
//        R.drawable.high5,
//        R.drawable.harry,
//        R.drawable.joji,
//        R.drawable.snoppy,
//        R.drawable.wopper
//    )
//
//    val imaName =
//        listOf("Batman", "Spiderman", "Roblox", "Gojo", "Silk", "Harry", "Joji", "snoopy", "wopper")
//    val product = listOf(
//        R.drawable.hoodie,
//        R.drawable.tshirt,
//        R.drawable.jacket,
//        R.drawable.jeanjacket,
//        R.drawable.jeansjacket,
//        R.drawable.many,
//        R.drawable.retro,
//        R.drawable.dino,
//        R.drawable.zipup
//    )
//
//    val imaPrice = listOf("1200", "500", "760", "999", "200", "250", "800")
//    val productPrice = listOf("2100", "1500", "1760", "999", "2200", "1250", "800")
val context= LocalContext.current
    val productViewModel = remember { ProductViewModel(ProductRepoImlp()) };
    LaunchedEffect(key1 = Unit) {
        productViewModel.getAllProduct()

    }
    val allProduct = productViewModel.allproducts.observeAsState(initial = emptyList())

    var showDialog by remember { mutableStateOf(false) }


    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { if(showDialog){
          AlertDialog(
              onDismissRequest = {
                  showDialog=false
              },
              confirmButton = {
                  TextButton(onClick = {}) {Text("Update") }
              },
              dismissButton = {
                  TextButton(onClick = {}) {Text("Cancel") }
              },
              title = {
                  Text("Update Product")
              },
              text = {
                  OutlinedTextField(
                      value = productName,
                      onValueChange = { productName = it },

                      label = {
                          Text(
                              "Product Name",
                              style = TextStyle(color = Color.Black)
                          )
                      },

                      shape = RoundedCornerShape(15.dp),

                      singleLine = true,
                      modifier = Modifier
                          .fillMaxWidth(),

                      colors = TextFieldDefaults.colors(
                          focusedContainerColor = Color.Gray,
                          unfocusedContainerColor = Color.Gray,
                          focusedIndicatorColor = Color.Gray,
                          unfocusedIndicatorColor = Color.Transparent
                      ),

                      )
                  OutlinedTextField(
                      value = productDescription,
                      onValueChange = { productDescription = it },

                      label = {
                          Text(
                              "Product Description",
                              style = TextStyle(color = Color.Black)
                          )
                      },

                      shape = RoundedCornerShape(15.dp),

                      singleLine = true,
                      modifier = Modifier
                          .fillMaxWidth(),
                      colors = TextFieldDefaults.colors(
                          focusedContainerColor = Color.Gray,
                          unfocusedContainerColor = Color.Gray,
                          focusedIndicatorColor = Color.Gray,
                          unfocusedIndicatorColor = Color.Transparent
                      ),

                      )
                  OutlinedTextField(
                      value = productPrice,
                      onValueChange = { productPrice = it },

                      label = {
                          Text(
                              "Product Price",
                              style = TextStyle(color = Color.Black)
                          )
                      },

                      shape = RoundedCornerShape(15.dp),

                      singleLine = true,
                      modifier = Modifier
                          .fillMaxWidth(),

                      colors = TextFieldDefaults.colors(
                          focusedContainerColor = Color.Gray,
                          unfocusedContainerColor = Color.Gray,
                          focusedIndicatorColor = Color.Gray,
                          unfocusedIndicatorColor = Color.Transparent
                      ),

                      )
                  OutlinedTextField(
                      value = productStock,
                      onValueChange = { productStock = it },

                      label = {
                          Text(
                              "Product Stock",
                              style = TextStyle(color = Color.Black)
                          )
                      },

                      shape = RoundedCornerShape(15.dp),

                      singleLine = true,
                      modifier = Modifier
                          .fillMaxWidth(),
                          
                      colors = TextFieldDefaults.colors(
                          focusedContainerColor = Color.Gray,
                          unfocusedContainerColor = Color.Gray,
                          focusedIndicatorColor = Color.Gray,
                          unfocusedIndicatorColor = Color.Transparent
                      ),

                      )
              }
          )
        }
        }

        items(allProduct.value!!.size) { index ->
            val data = allProduct.value!![index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F5F5)
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = data.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "${data.price}",
                            fontSize = 14.sp,
                            color = Color(0xFF388E3C),
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = data.description,
                            fontSize = 13.sp,
                            color = Color.DarkGray,
                            maxLines = 2,

                        )
                    }

                    IconButton(
                        onClick = {
                            productViewModel.deleteProduct(data.productId) { success, msg ->
                                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                            }
                        }
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = null,
                                tint = Color(0xFFD32F2F),
                                modifier = Modifier.clickable(
                                    onClick = {
                                       productViewModel.deleteProduct(data.productId){
                                           success,msg->{
                                               Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                           }
                                       }
                                    }

                                )

                            )
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = null,
                                tint = Color(0xFFD32F2F),
                                modifier = Modifier.clickable(
                                    onClick = {
                                        showDialog = true
                                    }

                                )
                            )
                        }
                    }

                }
            }

//            Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp).background(color = Color.LightGray))
//            Column {
//                Text(data.name)
//                Text(data.price.toString())
//                Text(data.description)
//                IconButton(onClick = {
//                    productViewModel.deleteProduct(data.productId){
//                        success,msg->
//                        if(success){
//                            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
//
//                        }else{
//                            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
//
//
//                        }
//                    }
//                }) {
//                    Icon(
//                        Icons.Filled.Delete,
//                        contentDescription = null
//                    )
//                }
//            }

        }


//        item {
//            Column(
//                modifier = Modifier.fillMaxWidth().background(Color.LightGray),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth(0.9f)
//                        .shadow(elevation = 4.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color.White)
//                ) {
//                    Row(
//                        modifier = Modifier.padding(16.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Icon(
//                            painter = painterResource(R.drawable.baseline_search_24),
//                            contentDescription = "Search Icon"
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Text("Search", style = TextStyle(color = Color.Gray))
//                    }
//                }
//
//
//                Spacer(Modifier.height(10.dp))
//
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth(0.9f)
//                        .shadow(elevation = 4.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
//                ) {
//                    Row(
//                        modifier = Modifier.padding(16.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Icon(
//                            painter = painterResource(R.drawable.baseline_location_on_24),
//                            contentDescription = "Location Icon"
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Column(modifier = Modifier.weight(1f)) {
//                            Text("Location", style = TextStyle(fontWeight = FontWeight.Bold,))
//                            Text("Select your location", style = TextStyle(fontSize = 10.sp))
//                        }
//                        Icon(
//                            painter = painterResource(R.drawable.baseline_arrow_drop_down_24),
//                            contentDescription = "Dropdown Arrow"
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.height(20.dp))
//                Image(
//                    painter = painterResource(R.drawable.salebanner),
//                    contentDescription = null,
//                    modifier = Modifier.fillMaxWidth(),
//                    contentScale = ContentScale.Crop
//                )
//                Spacer(modifier = Modifier.height(20.dp))
//                LazyRow {
//                    items(images.size) { index ->
//                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                            Image(
//                                painter = painterResource(images[index]),contentDescription = null, modifier = Modifier.size(80.dp).padding(end = 5.dp), contentScale = ContentScale.Crop
//                            )
//                            Text(imaName[index], textAlign = TextAlign.Center);
//                        }
//                    }
//                }
//                Spacer(modifier = Modifier.height(20.dp))
//
//            }
//        }
//
//        item() {
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Text("Flash sale", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp), modifier = Modifier.padding(horizontal = 10.dp))
//            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
//                Text("Only few items left, Ending soon",modifier = Modifier.padding(horizontal = 10.dp))
//                Text("20 items left ->", style = TextStyle(color = Color.Red))
//            }
//            Spacer(modifier = Modifier.height(20.dp))
//        }
//        item {
//                    LazyRow {
//                        items(images.size) { index ->
//                            Card(
//                                modifier = Modifier
//                                    .width(120.dp)
//                                    .padding(horizontal = 4.dp)
//                                    .shadow(elevation = 10.dp),
//                                colors = CardDefaults.cardColors(containerColor = Color.White)
//                            ) {
//                                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
//                                    Image(
//                                        painter = painterResource(images[index]),
//                                        contentDescription = null,
//                                        modifier = Modifier.size(100.dp),
//                                        contentScale = ContentScale.Crop
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), horizontalAlignment = Alignment.Start) {
//                                        Text(imaName[index])
//                                        Text("RS." + imaPrice[index], style = TextStyle(color = Color.Red))
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//        item() {
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Text("Recommended for you", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp), modifier = Modifier.padding(horizontal = 10.dp))
//            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
//                Text("Buy them before its too late!",modifier = Modifier.padding(horizontal = 10.dp))
//                Text("see all", style = TextStyle(color = Color.Red))
//            }
//            Spacer(modifier = Modifier.height(20.dp))
//        }
//        item{
//        LazyRow {
//            items(images.size) { index ->
//                Card(
//                    modifier = Modifier
//                        .width(120.dp)
//                        .padding(horizontal = 4.dp)
//                        .shadow(elevation = 4.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color.White)
//                ) {
//                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
//                        Image(
//                            painter = painterResource(product[index]),
//                            contentDescription = null,
//                            modifier = Modifier.size(100.dp),
//                            contentScale = ContentScale.Crop
//                        )
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), horizontalAlignment = Alignment.Start) {
//                            Text(imaName[index])
//                            Text("RS." + productPrice[index], style = TextStyle(color = Color.Red))
//                        }
//                    }
//                }
//            }
//        }}
    }
}



@Preview
@Composable
fun HomePreview(){
    HomeScreen()
}