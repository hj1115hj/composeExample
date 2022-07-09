package com.joocoding.android.app.todolist.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.joocoding.android.app.todolist.R
import com.joocoding.android.app.todolist.ui.main.components.TodoItem
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    //시험기능 api사용
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("오늘 할일") }
            )
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                value = text,
                onValueChange ={
                    text = it // 리컴포지션이 다시 수행된다.
                },
                placeholder = {Text("할 일")},
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = null)
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                //done key 눌렀을때 처리
                keyboardActions = KeyboardActions(onDone = {
                    viewModel.addTodo(text)
                    text = ""
                    keyboardController?.hide() // 키보드를 숨긴다
                })

            )
            Divider()

            LazyColumn(
                contentPadding = PaddingValues(16.dp), //contents 패팅
                verticalArrangement = Arrangement.spacedBy(16.dp), //item 간의 간격
            ){
                items(viewModel.items.value ){ todoItem ->
                    Column {
                        TodoItem(
                            todo = todoItem,
                            onClick = { todo ->
                                viewModel.toggle(todo.uid)
                            },
                            onDeleteClick = { todo ->
                                viewModel.delete(todo.uid)
                                scope.launch {
                                    val result = scaffoldState.snackbarHostState.showSnackbar(
                                        message = "할일 삭제됨",
                                        actionLabel = "취소"
                                    )
                                    //snackbar에 있는 취소 액션을 클릭했다면
                                    if(result == SnackbarResult.ActionPerformed){
                                        viewModel.restoreTodo()
                                    }
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Divider(color = Color.Black,  thickness = 1.dp)
                    }
                }

            }
        }
    }
}