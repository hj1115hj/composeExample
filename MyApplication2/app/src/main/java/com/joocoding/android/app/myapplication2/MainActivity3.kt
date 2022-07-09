package com.joocoding.android.app.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // lazyColumn
      /*  setContent {
            LazyColumn(modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
            // 늦은 컬럼, 아이템의 개수를 지정해서 개수만큼 만든다?
                item{
                    Text("Header")
                }
                items(50){ index ->
                    Text("글씨 $index")
               }
                item{
                    Text("Footer")
                }
            }
        }*/
        // Column
        setContent {
            //스크롤 상태를 기억해주는 개체
            val rememberState = rememberScrollState()
            Column(modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
                .verticalScroll(rememberState)
            , verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                //안에있는 내용을 미리 만들어 놓은 것
                for (i in 1..50){
                    Text("글씨 $i")
                }
            }
        }
    }

}

