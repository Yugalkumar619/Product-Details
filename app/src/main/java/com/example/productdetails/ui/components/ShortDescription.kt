package com.example.productdetails.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productdetails.models.Product

@Composable
fun ShortDiscription(product: Product){

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(start = 20.dp, end = 20.dp, top = 40.dp)) {
            Row() {
                Text(fontWeight = FontWeight.Bold,
                    text = product.data?.brand_name?.uppercase().toString())
                Box(modifier = Modifier.fillMaxWidth(0.7f))

                Text(fontWeight = FontWeight.Bold,
                    text = product.data?.price?.removeRange(3, 5).toString()+ " KWD")
            }
        Box(modifier = Modifier.height(10.dp))
        Text(text = product.data?.name.toString(), color = Color.Gray)
        Text(text = "SKU " + product.data?.sku, color = Color.Gray)


    }
}

