package com.example.kot_start.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kot_start.model.ProductModel
import com.example.kot_start.model.UserModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductRepoImlp: ProductRepo {
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()

    val ref: DatabaseReference=database.getReference("products")
    override fun addProduct(
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        val id = ref.push().key.toString()
        model.productId = id




        ref.child(id).setValue(model).addOnCompleteListener {
        if(it.isSuccessful){
            callback(true,"Product Added")
        }
        else{
            callback(false,it.exception?.message.toString())
        }
        }
    }

    override fun updateProduct(
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(model.productId).updateChildren(model.toMap()).addOnCompleteListener {
            if(it.isSuccessful){
                callback(true,"Product Updated")
            }
            else{
                callback(false,it.exception?.message.toString())
            }
        }
    }

    override fun deleteProduct(
        productId: String,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(productId).removeValue().addOnCompleteListener {
            if(it.isSuccessful){
                callback(true,"Product Deleted")
            }
            else{
                callback(false,it.exception?.message.toString())
            }
        }
    }


    override fun getProductById(
        productId: String,
        callback: (Boolean, String, ProductModel?) -> Unit
    ) {
        ref.addValueEventListener(object : ValueEventListener {
    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()) {
            val product = snapshot.getValue(ProductModel::class.java)
            if (product != null) {
                callback(true, "Product Found", product)
            }
        }
    }

    override fun onCancelled(error: DatabaseError) {
        callback(false,error.message,null)
    }
})
    }



    override fun getAllProduct(callback: (Boolean, String, List<ProductModel>?) -> Unit) {
       ref.addValueEventListener(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               if (snapshot.exists()){
                   val allProduct = mutableListOf<ProductModel>()
                   for (data in snapshot.children){
                       val product = data.getValue(ProductModel::class.java)
                       if (product != null){
                           allProduct.add(product)
                       }
                   }
                   callback(true,"Product Found",allProduct)
               }
               else{
                   callback(false,"Product Not Found",null)
               }
           }

           override fun onCancelled(error: DatabaseError) {
              callback(false,error.message,null)
           }
       })

    }
}