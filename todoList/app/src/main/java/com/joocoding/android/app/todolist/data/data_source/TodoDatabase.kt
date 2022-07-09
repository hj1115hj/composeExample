package com.joocoding.android.app.todolist.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joocoding.android.app.todolist.domain.model.Todo

//version: 투두 객체가 바뀔때 앱을 삭제후 다시 설치하거나 verison을 옮겨주어야한다.
@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}