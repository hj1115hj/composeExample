package com.joocoding.android.app.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity8 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

//데이터가 달라지면(state개념) 화면은 다시그려진다.
// 라이브데이터는 state로 변경이 가능하다
@Composable
fun HomeScreen(mainViewModel: MainViewModel = viewModel()) {
    //안에 있는 값 변경
    val text1 = remember {
        mutableStateOf("Hello world")
    }
    //자체 변경(간단하게 사용하고 싶은 경우)
    var text2 : String by remember {
        mutableStateOf("Hello world")
    }
    //상태가 변경되어 다시 그려지게된다. //textfield 같이 임시적으로 사용하는 경우는 구조분해주로사용(코드가 좀 길어지는거 대비)
    val (text:String, setText:(String) -> Unit) = remember {
        mutableStateOf("Hello world")
    }

    //라이브 데이터 활용
    //text1과 같은기능
    val text3 : State<String> = mainViewModel.liveData.observeAsState("hello")
    Column() {
        Text("Hello World")
        Button(onClick = {
            text1.value = "변경"
            print(text1.value)
            text2 = "변경"
            print(text2)
            //text = "ddd"
            setText("변경")
            mainViewModel.changeValue("변경")
        }) {
            Text("클릭")
        }
        TextField(value = text, onValueChange = setText )
    }

}

//compose state 사용 일반적인 케이스
class MainViewModel : ViewModel() {
    private val _value : MutableState<String> = mutableStateOf("Hello")
    val value: State<String> = _value

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun changeValue(value: String){
        _value.value = value
    }
}
