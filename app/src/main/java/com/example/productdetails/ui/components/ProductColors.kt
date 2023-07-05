package com.example.productdetails.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productdetails.R
import com.example.productdetails.models.Attribute
import com.example.productdetails.models.ConfigurableOption
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import java.util.jar.Attributes

@Composable
fun productColors(colors: ConfigurableOption){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(20.dp)){
        Column(modifier = Modifier.align(Alignment.CenterStart)) {

            Text(text = "Color:", color = Color.Gray, fontWeight = FontWeight.Bold)

            Box(modifier = Modifier.height(20.dp)) {

            }
            Row(modifier = Modifier
                .height(100.dp)
                .horizontalScroll(rememberScrollState())) {
                colors.attributes?.forEach{url ->
                    Box(modifier = Modifier.padding(5.dp).fillMaxSize()) {
                        CirlclePhoto(url = url.swatch_url)
                    }
                }
            }
        }

    }
}

@Composable
fun CirlclePhoto(url : String?){
    GlideImage(
        modifier = Modifier
            .width(52.dp)
            .height(52.dp)
            .clip(CircleShape).border( width = 2.dp,
        color = Color.Black,
        shape = CircleShape),
        imageModel = url.toString(),
        // Crop, Fit, Inside, FillHeight, FillWidth, None
        contentScale = ContentScale.Crop,
        // shows an image with a circular revealed animation.
        circularReveal = CircularReveal(duration = 250),
        // shows a placeholder ImageBitmap when loading.
        placeHolder = ImageBitmap.imageResource(R.drawable.photo),
        // shows an error ImageBitmap when the request failed.
        error = ImageBitmap.imageResource(id = R.drawable.photo)
    )
}

@Composable
@Preview(showBackground = true)
fun productColorsPreview(){
}