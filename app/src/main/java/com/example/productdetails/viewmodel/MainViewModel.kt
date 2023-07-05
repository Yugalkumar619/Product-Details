package com.example.productdetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productdetails.data.repository.ProductRepository
import com.example.productdetails.models.Attribute
import com.example.productdetails.models.ConfigurableOption
import com.example.productdetails.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProduct()
        }
    }

    val product : LiveData<Product>
        get()  = repository.product


    val colors: LiveData<ConfigurableOption>
    get() = repository.colors

    val attr: LiveData<List<Attribute>>
        get() = repository.attr

}