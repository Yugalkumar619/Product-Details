package com.example.productdetails.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productdetails.R

@Composable
fun TopAppBar(text : String?){

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)){
//        androidx.compose.material.Icon(
//            imageVector = Icons.Default.ArrowBack,
//            contentDescription = null,
//        Modifier.align(alignment = Alignment.CenterStart)
//            .padding(start = 20.dp))

        Row(modifier =  Modifier.align(Alignment.Center)) {

            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                Modifier
                    .padding(start = 20.dp, top = 2.dp)
                    .size(25.dp))
            
            Box(modifier = Modifier.fillMaxWidth(0.7f)){
                if (text != null) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterEnd)
                            .padding(end = 30.dp, top = 2.dp),
                        text = text,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = null,
                Modifier
                    .padding(end = 5.dp)
                    .size(30.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.upload),
                contentDescription = null,
                Modifier
                    .padding(end = 5.dp)
                    .size(30.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.bag),
                contentDescription = null,
                Modifier
                    .padding(end = 5.dp)
                    .size(30.dp)
            )


        }

    }

}

@Composable
@Preview(showBackground = true)
fun TopAppBarPreview(){
    TopAppBar("Once Collection Weekly")
}