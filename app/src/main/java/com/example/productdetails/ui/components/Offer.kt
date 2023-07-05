package com.example.productdetails.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Offer(){
    Box(modifier = Modifier
        .padding(start = 20.dp, end = 20.dp)
        .fillMaxWidth()
        .height(90.dp).border( width = 2.dp,
            color = Color.LightGray,
            shape = RoundedCornerShape(10.dp)
        )
        ){
        Row(
            Modifier
                .align(Alignment.Center)
                ) {
            Column(Modifier.align(CenterVertically)) {
                Text(text = "or 4 intersest-free payments")
                Text(text = "0.88 KWD Learn More")
            }
            
            Box(modifier = Modifier.fillMaxWidth(0.3f))

            Image(painter = painterResource(id = com.example.productdetails.R.drawable.tabby),
                contentDescription = null,
            Modifier.size(90.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OfferPreview(){

    Offer()

}