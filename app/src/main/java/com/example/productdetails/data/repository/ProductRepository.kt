package com.example.productdetails.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.productdetails.data.remote.ProductService
import com.example.productdetails.models.Attribute
import com.example.productdetails.models.ConfigurableOption
import com.example.productdetails.models.Product
import javax.inject.Inject


class ProductRepository @Inject constructor(private val productService: ProductService) {

    private val productLiveData = MutableLiveData<Product>()
    private val conOptions = MutableLiveData<ConfigurableOption>()
    private val attributte = MutableLiveData<List<Attribute>>()

    val product: LiveData<Product>
        get() = productLiveData

    val colors: LiveData<ConfigurableOption>
        get() = conOptions

    val attr: LiveData<List<Attribute>>
        get() = attributte

    suspend fun getProduct(){
        val result = productService.getProduct()

        if (result?.body() != null){
            productLiveData.postValue(result.body())

            // new code
            if(result?.body()?.data?.configurable_option != null) {
                conOptions.postValue(result.body()!!.data?.configurable_option?.get(0) ?:
                ConfigurableOption("",0,null,""))

                attributte.postValue(colors.value?.attributes)
            }
        }
    }
}