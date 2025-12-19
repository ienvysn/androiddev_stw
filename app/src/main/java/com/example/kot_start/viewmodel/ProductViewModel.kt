package com.example.kot_start.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.kot_start.model.ProductModel
import com.example.kot_start.model.UserModel
import com.example.kot_start.repository.ProductRepo
import com.example.kot_start.repository.UserRepo

class ProductViewModel(val repo: ProductRepo) {
    fun addProduct(
        model: ProductModel,
        callback: (Boolean, String) -> Unit){
        repo.addProduct(model,callback)
    }
    fun updateProduct(model: ProductModel,callback: (Boolean, String) -> Unit){
        repo.updateProduct(model,callback)
    }
    fun deleteProduct(productId: String,callback: (Boolean, String) -> Unit){
        repo.deleteProduct(productId,callback)
    }

    private val _products= MutableLiveData< ProductModel?>()
    val products: MutableLiveData<ProductModel?>
        get() = _products

    private val _allproducts= MutableLiveData<List<ProductModel>?>()
    val allproducts: MutableLiveData<List<ProductModel>?>
        get() = _allproducts



    fun getProductById(productId: String,callback: (Boolean, String, ProductModel?) -> Unit){
        repo.getProductById(productId){
            sucess,msg,data->
            if(sucess){
                _products.postValue(data)
            }else{
                _products.postValue(data)

            }

        }
    }
    fun getAllProduct() {
        repo.getAllProduct { sucess, msg, data ->
            if (sucess) {
                _allproducts.postValue(data)
            } else {
                _allproducts.postValue(data)

            }
        }
    }


}