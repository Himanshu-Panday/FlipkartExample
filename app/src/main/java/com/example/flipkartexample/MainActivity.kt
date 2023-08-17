package com.example.flipkartexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.flipkartexample.datas.DataSource
import com.example.flipkartexample.datas.KartSource
import com.example.flipkartexample.image.ImageSource
import com.example.flipkartexample.ui.theme.FlipkartExampleTheme
import com.example.flipkartexample.ui.theme.TrueBlue

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlipkartExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "FlipKart",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                },
                                navigationIcon = {
                                    Image(
                                        painter = painterResource(id =R.drawable._citypng_com_hd_flipkart_round_logo_icon_transparent_png___2968x3114),
                                        contentDescription = "Logo",
                                        modifier = Modifier
                                            .size(40.dp)

                                    )
                                },
                                actions = {
                                    Icon(
                                        imageVector = Icons.Default.AccountCircle,
                                        contentDescription ="account",
                                        modifier = Modifier
                                            .padding(15.dp)
                                            .size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "search",
                                        modifier = Modifier
                                            .size(30.dp)
                                    )
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = TrueBlue)
                            )
                        }
                    ) {padding->
                        val state = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxSize()
                            .padding(padding)
                            .verticalScroll(
                                state = state,
                                enabled = true
                            )
                    ) {
                        val allData = ImageSource().getAll()
                        LazyRow(
                            contentPadding = PaddingValues(10.dp)
                        ){
                            items(allData){item->
                                Flip(item)

                            }
                        }
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.h5),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(205.dp, 200.dp)
                                    .padding(6.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.h7),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(205.dp, 200.dp)
                                    .padding(6.dp)
                            )
                        }
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.h9),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(140.dp)
                                    .padding(6.dp)
                                )
                            val alData = ImageSource().getAl()
                            LazyRow(contentPadding = PaddingValues(1.dp)){
                                items(alData){item ->
                                    Kart(item)
                                }
                            }
                        }
                        Image(
                            painter = painterResource(id = R.drawable.h10),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(2.dp)
                        )
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.h7),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(205.dp, 200.dp)
                                    .padding(6.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.h8),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(205.dp, 200.dp)
                                    .padding(6.dp)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.h3),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(2.dp)
                                .size(400.dp, 220.dp)
                        )

                        Text(
                            text = "Copyright - Himanshu",
                            fontFamily = FontFamily.Cursive,
                            color = TrueBlue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(2.dp)
                                .align(alignment = CenterHorizontally)
                            )
                    }

                    }
                }
            }
        }
    }
}
@Composable
fun Flip(item: DataSource){
    Card {
        Column {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = "app",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(color = Color.White)
                    .size(400.dp, 220.dp)
                    .padding(2.dp)
            )
        }
    }
}
@Composable
fun Kart(item: KartSource){
    Card {
        Column {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(color = Color.White)
                    .size(140.dp)
                    .padding(6.dp)
                )
        }
    }
}