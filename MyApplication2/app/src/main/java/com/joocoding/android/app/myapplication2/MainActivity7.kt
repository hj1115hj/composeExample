package com.joocoding.android.app.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.joocoding.android.app.myapplication2.ui.theme.MyApplication2Theme

class MainActivity7 : ComponentActivity() {
    //private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*      1. 상태가 변경이되면 recomposition이 실행되면서
        val data = mutableStateOf("Hello")가 다시 불려서 변경되지 않음
        2. remember는 기존에 있던 데이터를 기억하는 것
        */
/*        setContent {
            //1. val data = mutableStateOf("Hello")
            // 2.
            val data = remember { mutableStateOf("Hello")}
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = data.value,
                    fontSize = 30.sp,
                )
                Button(onClick = {
                    data.value = "Word"
                }) {
                    Text("변경")
                }
            }
        }*/
        //
/*
       setContent { //뷰모델로 변경
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = viewModel.data.value,
                    fontSize = 30.sp,
                )
                Button(onClick = {
                    viewModel.data.value = "Word"
                }) {
                    Text("변경")
                }
            }
        }*/
        setContent { //컴포즈 안에서 뷰모델 사용하기기
            val viewModel by viewModels<MainViewModel1>()
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = viewModel.data.value,
                    fontSize = 30.sp,
                )
                Button(onClick = {
                    viewModel.changeValue()
                }) {
                    Text("변경")
                }
            }
        }


    }
}

//viewModel은 Actvity와 라이프사이클을 동일하게 가져가기 때문에 remember 키워드 없이 관리할 수있다.
class MainViewModel1 : ViewModel() {
    private val _data = mutableStateOf("Hello")
    val data: State<String> = _data //외부에는 읽기 전용으로 제공

    fun changeValue() { //수정하기 위해 함수를 만듬.
        _data.value = "World"
    }
}
