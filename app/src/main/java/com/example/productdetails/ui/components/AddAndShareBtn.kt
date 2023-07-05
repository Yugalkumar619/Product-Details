package com.example.productdetails.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddAndShareBtn(){

    Box(modifier = Modifier
        .height(120.dp)
        .fillMaxWidth()){
        
        Column(Modifier.padding(top = 12.dp)) {

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 20.dp, end = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White),
                onClick = { /*TODO*/ }) {
                Text(text = "Add to bag")
            }
            Box(modifier = Modifier.height(15.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = RectangleShape
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black),
                onClick = { /*TODO*/ }) {
                Text(text = "Share")
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun AddAndShareBtnPreview(){
    AddAndShareBtn()
}