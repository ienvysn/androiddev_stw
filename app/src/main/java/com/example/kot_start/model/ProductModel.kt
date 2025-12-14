package com.example.kot_start.model

data class ProductModel(
    var productId:String="",
    val name:String="",
    val price: Double=0.0,
    val description:String="",
    val stock:String="",

) {
    fun toMap(): Map<String, Any> {
        return mapOf(
            "productId" to productId,
            "name" to name,
            "price" to price,
            "description" to description,
            "stock" to stock
        )
    }
}
