package com.joocoding.android.app.composelayout.tc3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.joocoding.android.app.composelayout.ui.theme.ComposeLyaoutTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLyaoutTheme {
                SimpleList()
            }
        }
    }
}

@Composable
fun SimpleList(){
   /* val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)){
        repeat(100){
            Text("Item #$it")
        }
    }*/
    val listSize = 100
   // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
   // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()
    Column {
        Row{
            Button(onClick = {
                coroutineScope.launch{
                    //0 is the first item index
                    //스크롤하는 동안 목록 렌더링 차단을 방지하기 위해 스크롤 API는 정지 함수입니다
                    scrollState.animateScrollToItem(0)
                }
            }){
                Text("Scroll to the top")
            }
            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }
        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }

}
@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}
@Preview(name ="defaultPreview", showBackground = true)
@Composable
fun DefaultPreview(){
    ComposeLyaoutTheme {
        SimpleList()
    }
}