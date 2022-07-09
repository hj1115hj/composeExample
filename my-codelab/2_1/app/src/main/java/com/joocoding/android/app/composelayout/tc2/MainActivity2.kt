package com.joocoding.android.app.composelayout.tc2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joocoding.android.app.composelayout.ui.theme.ComposeLyaoutTheme

/*
Scatffold
Scaffold를 사용하면 기본 머티리얼 디자인 레이아웃 구조로 UI를 구현할 수 있습니다.
Scaffold는 TopAppBar, BottomAppBar, FloatingActionButton, Drawer와 같은 가장 일반적인 최상위 머티리얼 구성요소를 위한 슬롯을 제공합니다.
Scaffold를 통해 이러한 구성요소가 올바르게 배치되고 함께 작동하는지 확인합니다.
 */
class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLyaoutTheme {
                LayoutCodelab()
            }
        }
    }
}

/*
Scaffold API의 모든 매개변수는 @Composable (InnerPadding) -> Unit 유형인 본문 콘텐츠를 제외하고 선택사항입니다. 람다가 패딩을 매개변수로 받습니다.
 이는 화면의 항목을 적절하게 제한하도록 콘텐츠 루트 컴포저블에 적용해야 하는 패딩입니다(Column과 같은 contents의 맨 위에 있는 패딩)
 */
@Composable
fun LayoutCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutCodelab")
                } ,
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
           /* Text(
                text = "LayoutsCodelab",
                style = MaterialTheme.typography.h3
            )*/
        }
    ) { innerPadding ->
        /* Column(modifier = Modifier.padding(it)) {
             Text(text = "Hi there!")
             Text(text = "Thanks for going through the Layouts codelabs")
         }*/
        BodyContent(Modifier.padding(innerPadding).padding(8.dp))
    }

}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelabs")
    }
}

@Preview
@Composable
fun LayoutCodelabPreview() {
    ComposeLyaoutTheme {
        LayoutCodelab()
    }
}
