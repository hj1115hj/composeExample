package com.joocoding.android.app.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*        setContent {
            val textValue: MutableState<String> = remember{
                mutableStateOf("")
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //키보드 입력시 동적으로 변화하게 해야함
                //text 값이 변경될때 리컴포즈 되면서 다시 들어온다
                TextField(value = textValue.value, onValueChange = {
                    textValue.value = it
                })
                Button(onClick = {}) {
                    Text("클릭!!")
                }
            }
        }*/
 /*       val textValue: MutableState<String> = remember{
            mutableStateOf("")
        }*/
        setContent {
            val (text, setValue) = remember{
                mutableStateOf("")
            }
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            val keyboardController = LocalSoftwareKeyboardController.current
            //sanckbar을 띄우기 위해서 코루틴 스코프를 띄운다
            Scaffold(
                scaffoldState = scaffoldState
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(value = text, onValueChange = setValue)
                    Button(onClick = {
                        keyboardController?.hide()
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Hello $text")
                        }
                    }) {
                        Text("클릭!!")
                    }
                }
            }

        }
    }
}

