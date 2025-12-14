package com.example.kot_start

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kot_start.model.ProductModel
import com.example.kot_start.repository.ProductRepoImlp
import com.example.kot_start.repository.UserRepoImpl
import com.example.kot_start.ui.theme.Kot_startTheme
import com.example.kot_start.viewmodel.ProductViewModel
import com.example.kot_start.viewmodel.UserViewModel

class AddProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AddProductBody()
        }
    }
}

@Composable
fun AddProductBody() {
    var context = LocalContext.current

    var productName by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productStock by remember { mutableStateOf("") }
//    ProductViewModel
    val productViewModel = remember { ProductViewModel(ProductRepoImlp()) };

    LazyColumn(Modifier.fillMaxSize()) {
        item {
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
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
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
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
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
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
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
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Gray,
                    unfocusedContainerColor = Color.Gray,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Transparent
                ),

                )

            Spacer(Modifier.height(20.dp))
            Button(
                onClick = {
                    val model = ProductModel(

                        name = productName,
                        description = productDescription,
                        price = productPrice.toDouble(),
                        stock = productStock
                    )
                    productViewModel.addProduct(model) { success, msg ->
                        {
                            if (success) {
                                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                            }
                        }

                    }

                },
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp

                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(10.dp),

                ) {
                Text("Add Product")
            }

        }

    }
}


@Preview()
@Composable
fun AddProductPreview() {
    AddProductBody()
}