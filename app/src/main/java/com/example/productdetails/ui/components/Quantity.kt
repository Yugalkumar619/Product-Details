package com.example.productdetails.ui.components

import android.view.Gravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Quantity(){

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(start = 20.dp)){
        Column(modifier = Modifier.align(Alignment.CenterStart)) {
            Text(text = "Quantity")
            Box(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    Modifier
                        .background(Color.Gray)
                        .height(40.dp)
                        .width(40.dp)){

                    Image(
                        modifier = Modifier.align(Alignment.Center).background(Color.Gray).size(10.dp),
                        painter = painterResource(com.example.productdetails.R.drawable.minus),
                        colorFilter = ColorFilter.tint(Color.White),
                        contentDescription =null )
                }
                Box(Modifier.width(5.dp))

                Box(
                    Modifier
                        .height(40.dp)
                        .width(80.dp)
                        .border(
                            width = 2.dp,
                            color = Color.DarkGray,
                            shape = RectangleShape
                        ),
                        ){

                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 18.sp,
                        text = "1")
                }

                Box(Modifier.width(5.dp))

                Box(
                    Modifier
                        .background(Color.Black)
                        .height(40.dp)
                        .width(40.dp)
                        .size(25.dp)){

                    Image(
                        modifier = Modifier.align(Alignment.Center).size(10.dp),
                        painter = painterResource(com.example.productdetails.R.drawable.plus),
                        colorFilter = ColorFilter.tint(Color.White),
                        contentDescription =null )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewQuantity(){
    Quantity()
}