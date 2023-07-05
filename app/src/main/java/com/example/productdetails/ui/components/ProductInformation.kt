package com.example.productdetails.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productdetails.R


@Composable
fun ProductInformation(){

    Box(modifier = Modifier
        .height(30.dp)
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 10.dp)){
        Row() {
            Text(text = "PRODUCT INFORMATION", fontWeight = FontWeight.Bold)
            Box(modifier = Modifier.fillMaxWidth(0.9f))
            Icon(
                painter = painterResource(id = R.drawable.arrowup),
                contentDescription = null,
                Modifier
                    .size(100.dp)
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun ProductInformationPreview(){

    ProductInformation()
}