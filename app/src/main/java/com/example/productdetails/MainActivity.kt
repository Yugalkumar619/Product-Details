package com.example.productdetails

import android.os.Bundle
import android.text.Html
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.example.productdetails.models.ConfigurableOption
import com.example.productdetails.ui.components.*
import com.example.productdetails.ui.theme.ProductDetailsTheme
import com.example.productdetails.util.LoadPicture
import com.example.productdetails.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

const val DEFAULT_RECIPE_IMAGE = R.drawable.photo

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContent {
            ProductDetailsTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Content(mainViewModel, this)
                }
            }
        }
    }
}

@Composable
fun Content( mainViewModel: MainViewModel, context: LifecycleOwner){

    mainViewModel.product.observe(context){

    }

    val repos by mainViewModel.product.observeAsState()

    val colors by mainViewModel.colors.observeAsState()

    val attr by mainViewModel.attr.observeAsState()

    Column {
        TopAppBar(repos?.data?.name)

        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.80f)) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                repos?.data?.image?.let { url ->
                    val image = LoadPicture(
                        url = url,
                        defaultImage = DEFAULT_RECIPE_IMAGE
                    ).value
                    image?.let { img ->
                        Image(
                            bitmap = img.asImageBitmap(),
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                    ImageDots()
                    ShortDiscription(repos!!)
                    if (!colors?.attributes.isNullOrEmpty()) {
                        colors?.let { productColors(it) }
                    }
                    Offer()
                    Quantity()
                }

                if (!repos?.data?.description.isNullOrBlank()) {
                    ProductInformation()
                    Greeting(
                        name = Html.fromHtml(repos?.data?.description, Html.FROM_HTML_MODE_COMPACT)
                            .toString()
                    )
                } else {
                    Progress()
                }
            }
        }
        AddAndShareBtn()



    }
}


@Composable
fun Greeting(name: String?) {
    Text(modifier = Modifier.padding(20.dp), color = Color.Gray, text = "Hello $name!")
}

@Composable
fun Progress(){
    Box(
        Modifier
            .fillMaxWidth()
            .height(600.dp)) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProductDetailsTheme {
        Progress()
    }
}