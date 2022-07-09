package com.joocoding.android.app.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Text("Hello world!")
            com.joocoding.android.app.tutorial.t2.PreviewMessageCard()
        }
    }
}


@Composable
fun MessageCard(name: String){
    Text(text ="hello $name!")
}
@Preview
@Composable
fun PreviewMessageCard2(){
    MessageCard(name = "Android")
}