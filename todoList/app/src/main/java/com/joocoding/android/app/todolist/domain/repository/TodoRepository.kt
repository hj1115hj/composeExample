package com.joocoding.android.app.todolist.domain.repository

import com.joocoding.android.app.todolist.domain.model.Todo
import kotlinx.coroutines.flow.Flow

//viewModel이 이 repository를 이용해서 데이터를 조작할 수 있도록 한다.
interface TodoRepository {
    fun observeTodos(): Flow<List<Todo>>

    suspend fun addTodo(todo: Todo)

    suspend fun updateTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)

}