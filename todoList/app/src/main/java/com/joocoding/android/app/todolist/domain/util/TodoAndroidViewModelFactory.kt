package com.joocoding.android.app.todolist.domain.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joocoding.android.app.todolist.data.repository.TodoRepositoryImpl
import com.joocoding.android.app.todolist.domain.repository.TodoRepository
import com.joocoding.android.app.todolist.ui.main.MainViewModel
//viewModel factory 생성
//특정 상황에서 내가 원하는 viewModel을 만들어서 사용하기 위해서 사용
class TodoAndroidViewModelFactory(
    private val application: Application,
    //viewModel 교체 가능
    private val repository: TodoRepository = TodoRepositoryImpl(application),
    )
    :ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //mainViewModel타입일 경우 경우에 뭘 할것인지 지정
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application, repository) as T
        }
        return super.create(modelClass)
    }
}