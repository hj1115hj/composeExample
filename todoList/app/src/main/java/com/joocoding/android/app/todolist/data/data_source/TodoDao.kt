package com.joocoding.android.app.todolist.data.data_source

import androidx.room.*
import com.joocoding.android.app.todolist.domain.model.Todo
import kotlinx.coroutines.flow.Flow

//Todo 객체를 활용한 데이터 엑세스 인터페이스
@Dao
interface TodoDao {
    //flow: 비동기적인 데이터의 흐름을 처리하기에 적합함
    //DESC: 최근에 수행한 내용이 맨 위로 올라가도록 정렬함
    @Query("SELECT * FROM todo ORDER BY date DESC")
    fun todos(): Flow<List<Todo>>

    //데이터를 쓰는 작업은 오래걸리기 때문에 suspend(코루틴) 함수를 사용한다
    //OnConflictStrategy.REPLACE 동일한 id를 가진 todo 객체를 insert할때 충돌이 발생하는데 그때 replace한다
    //데이터를 수정하고나 추가할때 insert 쿼리로 하나로 사용하기 위해서
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}