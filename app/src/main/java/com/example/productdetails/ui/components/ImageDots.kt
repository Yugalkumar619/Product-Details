package com.example.productdetails.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ImageDots(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(20.dp)
        .padding(start = 40.dp, end = 40.dp, top = 5.dp)){
        Row(Modifier.align(alignment = Alignment.Center)) {

            for (i in 1..20) {
                Canvas(modifier = Modifier.size(16.dp), onDraw = {
                    if(i==1){
                        drawCircle(color = Color.Black, radius = 17f)
                    }else{
                        drawCircle(color = Color(0xFFebbcac), radius = 17f)
                    }

                })
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun Show(){
    ImageDots()
}