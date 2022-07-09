package com.joocoding.android.app.todolist.data.repository

import android.app.Application
import androidx.room.Room
import com.joocoding.android.app.todolist.data.data_source.TodoDatabase
import com.joocoding.android.app.todolist.domain.model.Todo
import com.joocoding.android.app.todolist.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

//application: viewModel서 사용하는 application context를 그대로 사용하기 위해서
class TodoRepositoryImpl(application: Application) : TodoRepository{
    private val db = Room.databaseBuilder(
        application,
        TodoDatabase::class.java,
        "todo-db"
    ).build()

    override fun observeTodos(): Flow<List<Todo>> {
        return db.todoDao().todos()
    }

    override suspend fun addTodo(todo: Todo) {
        return db.todoDao().insert(todo)
    }

    override suspend fun updateTodo(todo: Todo) {
        return db.todoDao().update(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        return db.todoDao().delete(todo)
    }
}