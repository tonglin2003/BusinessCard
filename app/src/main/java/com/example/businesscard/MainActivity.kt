package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardImage(message = "Hi! I'm a student at College of Staten Island", name="Tong Lin", email="tong.lin2@cix.cuny.edu")
                }
            }
        }
    }
}

@Composable
fun BusinessCardText(message: String, name: String, email:String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp)
    )
    {
        Text(
            text = message,
            fontSize = 50.sp,
            lineHeight = 60.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Name: $name",
            fontSize = 36.sp,
            lineHeight = 60.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
            )
        Text(
            text = "Email: $email",
            fontSize = 36.sp,
            lineHeight = 50.sp,
            color = Color.Cyan,
            textAlign = TextAlign.Center
        )
    }
}


// testing for the github
@Composable
fun BusinessCardImage(message: String, name: String, email:String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.businesscardlogo)
    Box(modifier = modifier
        .fillMaxSize()
        .padding(8.dp)){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally)
        {
            BusinessCardText(
                message = message,
                name = name,
                email = email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Fit, // Keeps aspect ratio
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp) // Adjust height as needed
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardImage(message = "Hi! I'm a student at College of Staten Island", name="Tong Lin", email="tong.lin2@cix.cuny.edu")
    }
}