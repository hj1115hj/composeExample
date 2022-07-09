package com.joocoding.android.app.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joocoding.android.app.myapplication2.ui.theme.MyApplication2Theme

class MainActivity2 : ComponentActivity() {
   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Box(modifier = Modifier.background(color= Color.Green)
               .fillMaxSize(),
               contentAlignment = Alignment.TopEnd
           ){
               Box(modifier = Modifier
                   .wrapContentSize()
                   .background(color = Color.Blue)
                   .padding(100.dp)
                   ,
               contentAlignment = Alignment.Center) {
                   Text("12345678~~~~~~~~~~")
               }
               Text("Hello")
           }
        }
    }*/
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContent {
           Box(modifier = Modifier.background(color= Color.Green)
               .fillMaxWidth()
               .height(200.dp)
           ){
               Text("Hello")
               Box(modifier = Modifier
                   .fillMaxSize()
                   //.padding(50.dp)
                   .background(color = Color.Blue)
                  //.padding(50.dp)
                   ,
                   contentAlignment = Alignment.BottomEnd) {
                   Text("12345678~~~~~~~~~~")
               }

           }
       }
   }
}

