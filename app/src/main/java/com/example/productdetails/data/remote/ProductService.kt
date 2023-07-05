package com.example.productdetails.data.remote

import com.example.productdetails.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("6701/253620?lang=en&store=KWD")
    suspend fun getProduct(): Response<Product>
}