package com.joocoding.android.app.todolist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
//entity를 지정해두면 자동으로 room database에서 사용가능
//todo 테이블이 만들어진다
@Entity
data class Todo(
    val title: String,
    val date: Long = Calendar.getInstance().timeInMillis,
    val isDone: Boolean = false,
) {
    //id는 동적으로 값이 정해져야하므로 생성자 안에 만들지 않는다
    //유니크한 값으로 가장 큰 아이디값에 +1만큼 자동으로 id를 증가한다
    //0으로 해야 자동증가됨
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

}